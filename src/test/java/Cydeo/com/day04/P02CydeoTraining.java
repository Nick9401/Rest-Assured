package Cydeo.com.day04;

import Cydeo.com.utilities.CydeoTrainingTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class P02CydeoTraining extends CydeoTrainingTestBase {
    /*
    Given accept type is application/json
    And path param is 2
    When user send request /student/{id}
    Then status code should be 200
    And content type is application/json;charset=UTF-8
    And Date header is exist
    And Server header is envoy
    And verify following
                firstName Mark
                batch 13
                major math
                emailAddress mark@email.com
                companyName Cydeo
                street 777 5th Ave
                zipCode 33222
     */

    @DisplayName("GET /student/{id} 2 ")
    @Test
    public void test1() {

        Response response = given().log().all().accept(ContentType.JSON)
                .and()
                .pathParam("id", 2).
                when().get("/student/{id}");

        response.prettyPrint();


        assertEquals(200, response.statusCode());

        assertEquals("application/json;charset=UTF-8", response.contentType());

        assertTrue(response.headers().hasHeaderWithName("Date"));

        assertEquals("envoy", response.header("server"));

        /*
         firstName Mark               ---> students[0].firstName
         batch 13                     ---> students[0].batch
         major math                   ---> students[0].major
         emailAddress mark@email.com  ---> students[0].contact.emailAddress
         companyName Cydeo            ---> students[0].company.companyName
         street 777 5th Ave           ---> students[0].company.address.street
         zipCode 33222                ---> students[0].company.address.zipCode
         */

        // Create JSON PATH OBJECT
        JsonPath jsonPath = response.jsonPath();

        assertEquals("Mark", jsonPath.getString("students[0].firstName"));

        assertEquals(13, jsonPath.getInt("students[0].batch"));

        assertEquals("math", jsonPath.getString("students[0].major"));

        assertEquals("mark@email.com", jsonPath.getString("students[0].contact.emailAddress"));

        assertEquals("Cydeo", jsonPath.getString("students[0].company.companyName"));

        assertEquals("777 5th Ave", jsonPath.getString("students[0].company.address.street"));

        assertEquals(33222, jsonPath.getInt("students[0].company.address.zipCode"));


    }

      /*
    TASK
    Given accept type is application/json
    And path param is 22
    When user send request /student/batch/{batch}
    Then status code should be 200
    And content type is application/json;charset=UTF-8
    And Date header is exist
    And Server header is envoy
    And verify all the batch number is 22
     */

    @DisplayName("Aplication")
    @Test
    public void task() {
        Response response = given().accept(ContentType.JSON)
                .pathParams("batch", 22)
                .get("/student/batch/{batch}");
        assertEquals(response.statusCode(), 200);
        assertEquals("application/json;charset=UTF-8", response.contentType());
        assertTrue(response.headers().hasHeaderWithName("date"));
        assertTrue(response.headers().hasHeaderWithName("envoy"));


    }
//    TASK 1
//    Given Accept application/json
//    And path zipcode is 22031
//    When I send a GET request to /us endpoint
//    Then status code must be 200
//    And content type must be application/json
//    And Server header is cloudflare
//    And Report-To header exists
//    And body should contains following information
//    post code is 22031
//    country is United States
//    country abbreviation is US
//    place name is Fairfax
//    state is Virginia
//    latitude is 38.8604




}
