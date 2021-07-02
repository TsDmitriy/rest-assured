package core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import pojo.BreedsPojo;
import pojo.FavouritesPogo;
import pojo.MessagePogo;
import pojo.ResponsePojo;
import untils.Stash;

import java.util.List;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

public class BreedsReq {

    public BreedsReq getbreedid() {
        String breedsPojos =
                given()
                        .baseUri("http://api.thecatapi.com")
                        .contentType(ContentType.JSON)
                        .header("x-api-key", "6a040f7b-7230-479a-a94f-ce5bccf7937b")
                        .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36")
                        .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                        .header(":scheme", "https")
                        .queryParam("q", "Scottish Fold")
                        .when().get("/v1/breeds/search")
                        .body().asPrettyString();

        String resp = breedsPojos.substring(1, breedsPojos.length() - 1);
        Gson gson = new Gson();
        BreedsPojo response = gson.fromJson(resp, BreedsPojo.class);
        String b = response.getId();
        Stash.put("breed_id", b);
        return this;
    }

    public BreedsReq getImages() throws JsonProcessingException {

        String imagesSearch =
                given()
                        .baseUri("http://api.thecatapi.com")
                        .contentType(ContentType.JSON)
                        .header("x-api-key", "6a040f7b-7230-479a-a94f-ce5bccf7937b")
                        .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36")
                        .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                        .header(":scheme", "https")
                        .queryParam("breed_id", Stash.getValue("breed_id"))
                        .when().get("/v1/images/search").body().asPrettyString();

        String resp = imagesSearch.substring(1, imagesSearch.length() - 1);
        Gson gson = new Gson();
        ResponsePojo response = gson.fromJson(resp, ResponsePojo.class);
        Assertions.assertTrue(response.getBreeds().get(0).getId().equals("sfol"));
        Stash.put("id", response.getId());
        Stash.put("urlImages", response.getUrl());
        return this;
    }

    public BreedsReq favouritesAdd() {

        JSONObject requestParams = new JSONObject();
        requestParams.put("image_id", Stash.getValue("id"));

        RestAssured.baseURI = "http://api.thecatapi.com";

        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.header("x-api-key", "6a040f7b-7230-479a-a94f-ce5bccf7937b");
        request.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36");
        request.header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        request.header(":scheme", "https");

        request.body(requestParams.toString());
        Response response = request.post("/v1/favourites");

        Gson gson = new Gson();
        MessagePogo resp = gson.fromJson(response.asPrettyString(), MessagePogo.class);

        String successCode = resp.getMessage();
        String imageId = Integer.toString(resp.getId());
        Stash.put("idFavourites", imageId);
        Assertions.assertEquals("SUCCESS", successCode, "Некорректный статус");
        return this;
    }

    public BreedsReq checkFavourites() {

        RestAssured.baseURI = "https://api.thecatapi.com/";

        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.header("x-api-key", "6a040f7b-7230-479a-a94f-ce5bccf7937b");
        request.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36");
        request.header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        request.header(":scheme", "https");


        Response response = request.get("/v1/favourites");
        List<Integer> successCode = response.jsonPath().get("id");
       Assertions.assertTrue(successCode.stream().anyMatch(x->x.toString().equals(Stash.getValue("idFavourites"))));
//        for (int b=0 ; b<=successCode.size()-1;b++) {
//            int i =0;
//            if (successCode.get(b).toString().equals("1")) {
//               i++;
//            }
//            if (i>0) {
//               break;
//            }
//            else  if (b==successCode.size()-1){
//                Assertions.fail("ERROR");
//            }
//
//        }
        return this;
    }
}
