package api.stepdefinitions;


import api.utulities.TestBaseTrello;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import ui.utulities.ConfigReader;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class Trello2 extends TestBaseTrello {

    Response response;
    JsonPath jsonPath;

    @Given("POST request for create board")
    public void send_post_request_for_create_board() {

        //url tanımla
        //expected data-request data
        // request gönder
        //resposu al
        //assert et
        setUp();
        spec.pathParams("parametre1",1,"parametre2","boards");


        HashMap<String,Object> requestBody=new HashMap<>();
        requestBody.put("name","Myamazon");
        requestBody.put("key", ConfigReader.getProperty("key"));
        requestBody.put("token",ConfigReader.getProperty("token"));

        System.out.println(requestBody);

        response =given().
                contentType("application/json").
                spec(spec).
                body(requestBody).
                when().
                post("/{parametre1}/{parametre2}/");
        response.prettyPrint();
        JsonPath jsonPath=response.jsonPath();
    }
    @Then("Assert status code {int}")
    public void assertStatusCode(int statusCode) {

        Assert.assertEquals(statusCode,response.getStatusCode());
    }
    @Then("Assert board name")
    public void assert_board_name_is() {

        Assert.assertEquals("Myamazon",jsonPath.getString("name"));
    }

}