package Cydeo.com.day04;

import Cydeo.com.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class P01_HRWithJsonPath extends HrTestBase {
    //Status code 200

    // get all emails from response

    //get all emails who is working as IT_PROG

    // get me all employees first names whose salary is more than 10000

    // get me all information from response  who has max salary

    // get me firstname from response  who has max salary
    @DisplayName("Get All employees ")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .queryParam("limit", 200)
                .get("/employees");


        response.prettyPrint();

        assertEquals(response.statusCode(),200);

        List<String> emails = response.path("items.email");
        System.out.println("emails = " + emails);






    }
}
