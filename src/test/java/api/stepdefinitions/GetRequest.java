package api.stepdefinitions;

import api.utulities.TestBaseTrello;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class GetRequest extends TestBaseTrello {



    @Given("Get request for Carts")
    public void get_request_for_carts() {

        Response response;

        setUp();
        spec.pathParams("param1",1,"param2","boards","param3","62278e3d1f4bc2163086af3b","param4","cards");
        //url tanımla
        //expected data-request data
        // request gönder
        //resposu al
        //assert et
        HashMap<String,Object> keyToken=new HashMap<>();
        keyToken.put("key","34da62bcc3f5cf93015903ce428b290e");
        keyToken.put("token","4c0a5c365c1a1c399aa45805f980689b6eeceacf59a6b6babb8aca672e609f59");

        response=given().
                spec(spec).
                contentType("application/json").
                body(keyToken).
                when().
                get("/{param1}/{param2}/{param3}/{param4}");

        response.prettyPrint();

        System.out.println(response.getStatusCode());


    }

}
