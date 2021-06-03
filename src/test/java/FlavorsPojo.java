import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class FlavorsPojo {

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)

    private String name;

    private String url;
}
