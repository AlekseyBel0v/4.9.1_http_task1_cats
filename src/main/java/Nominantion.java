import com.fasterxml.jackson.annotation.JsonProperty;

public class Nominantion {
    private String id;
    private String text;
    private String type;
    private String user;
    private Integer upvotes;

    public Integer getUpvotes() {
        return upvotes;
    }

    Nominantion(
            @JsonProperty("id") String id,
            @JsonProperty("text") String text,
            @JsonProperty("type") String type,
            @JsonProperty("user") String user,
            @JsonProperty("upvotes") Integer upvotes
        ) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    @Override
    public String toString() {
        return "\nid " + id + ":" +
               "\ntext = " + text +
               "\ntype = " + type +
               "\nuser = " + user +
               "\nupvotes = " + upvotes;
    }
}
