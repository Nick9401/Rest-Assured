package Cydeo.com.day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PO2NegativeSpartanTest {


    @BeforeAll
    public static void init(){
        RestAssured.baseURI="http://44.204.184.184:8000";

    }


    @DisplayName("Get All spartans")
    @Test
    public void HelloSpartans() {

        Response response = RestAssured
                .given()
                .accept(ContentType.XML)
                .when()
                .get("/api/spartans/10");

        int actualStatusCode = response.statusCode();
        Assertions.assertEquals(200, actualStatusCode);
    }

    @Test
    public void test2(){
        /*
        Given Accept type application/xml
        When user send GET request to /api/spartans/10 end point
        Then status code must be 406
        And response Content Type must be application/xml;charset=UTF-8;
    */
        Response response = RestAssured
                .given()
                .accept(ContentType.XML)
                .when()
                .get("/api/spartans/10");



        Assertions.assertEquals(406, response.statusCode());
        Assertions.assertEquals("application/xml;charset=UTF-8",response.contentType());



    }
}