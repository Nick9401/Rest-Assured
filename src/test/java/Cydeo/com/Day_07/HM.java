package Cydeo.com.Day_07;

import Cydeo.com.POJO.Spartan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import Cydeo.com.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import java.util.Map;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HM extends SpartanTestBase {


    /*
    Create a Spartan Flow to run below testCases dynamicly
   - POST     /api/spartans
            Create a spartan Map
                name = "API Flow POST"
                gender="Male"
                phone=1231231231l
            - verify status code 201
            - message is "A Spartan is Born!"
            - take spartanID from response and save as a global variable
    - GET  Spartan with spartanID     /api/spartans/{id}
             - verify status code 200
             - verfiy name is API Flow POST
    - PUT  Spartan with spartanID    /api/spartans/{id}
             Create a spartan Map
                name = "API PUT Flow"
                gender="Female"
                phone=3213213213l
             - verify status code 204
    - GET  Spartan with spartanID     /api/spartans/{id}
             - verify status code 200
             - verify name is API PUT Flow
    - DELETE  Spartan with spartanID   /api/spartans/{id}
             - verify status code 204
     - GET  Spartan with spartanID   /api/spartans/{id}
             - verify status code 404
    Challenges
       Create @Test annotated method for each Request
       Put them in order to execute as expected
                    - Use your googling skills
                    - How to run Junit5 Tests in order  ?
     */


    static int spartanID;
    static Spartan spartanPost ;
    static Spartan spartanPut ;


    @Order(1)
    @Test
    public void POST() {


        spartanPost = new Spartan();
        spartanPost.setName("API POST Flow");
        spartanPost.setGender("Male");
        spartanPost.setPhone(8877445596l);


        spartanID = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(spartanPost).
                when().post("/api/spartans").
                then()
                .statusCode(201)
                .body("success", is("A Spartan is Born!")).extract().jsonPath().getInt("data.id");


        System.out.println(spartanID + " is created");


    }
    @Order(2)
    @Test
    public void GETSpartan_01() {

        given().accept(ContentType.JSON)
                .pathParam("id", spartanID).
                when()
                .get("/api/spartans/{id}").
                then()
                .statusCode(200)
                .body("name",is(spartanPost.getName()));
    }

    @Order(3)
    @Test
    public void PUT() {

        spartanPut = new Spartan();
        spartanPut.setName("API PUT Flow");
        spartanPut.setGender("Male");
        spartanPut.setPhone(8877445596l);

        given()
                .contentType(ContentType.JSON)
                .pathParam("id", spartanID)
                .body(spartanPut).
                when().put("/api/spartans/{id}").
                then()
                .statusCode(204);


        System.out.println(spartanID + " is updated");


    }


    @Order(4)
    @Test
    public void GETSpartan_02() {

        given().accept(ContentType.JSON)
                .pathParam("id", spartanID).
                when()
                .get("/api/spartans/{id}").
                then()
                .statusCode(200)
                .body("name", is(spartanPut.getName()));


    }
    @Order(5)
    @Test
    public void DELETE() {

        given()
                .pathParam("id", spartanID)
                .when().delete("/api/spartans/{id}")
                .then().statusCode(204);


        System.out.println(spartanID + " is deleted");


    }
    @Order(6)
    @Test
    public void GETSpartan() {

        given().accept(ContentType.JSON)
                .pathParam("id", spartanID).
                when()
                .get("/api/spartans/{id}").
                then()
                .statusCode(404);

        System.out.println(spartanID + " is not exist");

    }}