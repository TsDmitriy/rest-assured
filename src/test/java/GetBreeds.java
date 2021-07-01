
import com.fasterxml.jackson.core.JsonProcessingException;
import core.BreedsReq;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetBreeds {


    @Test
    public void test() throws JsonProcessingException {
        new BreedsReq().getbreedid()
                .getImages().favouritesAdd();


    }

}

