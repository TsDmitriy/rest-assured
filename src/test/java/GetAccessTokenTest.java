import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class GetAccessTokenTest {


    @Test
    public void test() throws Exception {
     List<FlavorsItem>  list=  given()
                .baseUri("https://pokeapi.co/api/v2/berry/1")
                .contentType(ContentType.JSON)
                .when().get()
                .then().log().body()
                .statusCode(200)
//                .body("flavors.flavor.name", equalTo("soft1"))
                .extract().jsonPath().getList("flavors.potency",FlavorsItem.class);

    }

}

