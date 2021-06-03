import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAccessTokenTest {


    @Test
    public void test() throws Exception {


     List<FlavorsItem>  list=  given()
                .baseUri("https://pokeapi.co/api/v2/berry/1")
                .contentType(ContentType.JSON)
                .when().get()
                .then().log().body()
                .statusCode(200)
                .extract().jsonPath().getList("firmness",FlavorsItem.class);

    }

}

