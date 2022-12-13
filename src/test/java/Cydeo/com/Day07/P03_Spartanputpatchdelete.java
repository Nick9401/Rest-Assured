package Cydeo.com.Day07;

import Cydeo.com.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;


import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class P03_Spartanputpatchdelete  extends SpartanTestBase {

    @Test
    public void test1() {
        Map<String,Object> requestBody=new LinkedHashMap<>();
        requestBody.put("name","James Bond");
        requestBody.put("gender","Male");
        requestBody.put("phone", 1234567890L);

        int id = 319;

        given().accept(ContentType.JSON)
                .pathParams("id",id)
                .body(requestBody)
                .when().put("/api/spartans/{id}")
                .then().statusCode(204);



    }
}
