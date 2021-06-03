import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class FlavorsPojo {

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)

        private String name;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    private String url;
}
