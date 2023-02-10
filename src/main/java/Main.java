import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static ObjectMapper mapper = new ObjectMapper();
    private static final String URI_CATS = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //Создание объекта запроса с произвольными загаловками
        HttpGet request = new HttpGet(URI_CATS);
        //Добавление заголовка формата ответа
        request.addHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
        //Отправка запроса
        CloseableHttpResponse response = httpClient.execute(request);
        //Вывод всех заголовков
        Arrays.stream(response.getAllHeaders()).forEach(System.out::println);
        //Чтение ответа
        //String body = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
        //System.out.println(body);

        //десерриализация из строки json в объекты (дополнительно см. класс Nomination)
        List<Nominantion> nominantions = mapper.readValue(response.getEntity().getContent(), new TypeReference<>() {
        });
        //System.out.println(nominantions.toString());

        List<Nominantion> selectedNominantions = nominantions.stream().filter(x -> x.getUpvotes() != null && x.getUpvotes() > 0).toList();
        System.out.println(selectedNominantions.toString());
    }
}