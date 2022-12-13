package Cydeo.com.day08;

import Cydeo.com.utilities.SpartanAuthTestbase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

public class P01_SpartanAuth extends SpartanAuthTestbase {

    @Test
    void test1() {

        // it is Negative Test Case
        given().accept(ContentType.JSON).
                when().get("/api/spartans").
                then().log().ifValidationFails().statusCode(401)
                .body("error", is("Unauthorized"));
    }

    @Test
    void test2() {

        // it is Negative Test Case
        given().accept(ContentType.JSON).log().all()
                        .auth().basic("user","user")
                .when().get("/api/spartans").prettyPeek()
                .then().log().ifValidationFails().statusCode(401);

    }
    @Test
    void test3() {

        // it is Negative Test Case
      given().pathParams("id",56)
              .auth().basic("editor","editor")
              .when().delete("/api/spartan/{id}").then().statusCode(403)
              .body("error",is("Forbidden"));

}
}