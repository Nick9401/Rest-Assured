package Cydeo.com.day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;
import java.util.List;

public class P01_SpartanGetRequest {
    String url="http://44.204.184.184:8000";


    /*
     * Given accept  content type is application/json
     * When user sends GET request /api/spartans endpoint
     * Then status code should be 200
     * And Content type should be application/json
     */
    @DisplayName("Get All Spartan")
    @Test
    public void getAllSpartans() {

        Response response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get(url+"/api/spartans");

        // print response
        // response.prettyPrint();


        // how to get status code
        int actualStatusCode = response.statusCode();

        Assertions.assertEquals(200, actualStatusCode);

        //how can we get ContentType
        String actualContentType = response.contentType();

        Assertions.assertEquals("application/json", actualContentType);

        //how to get header info
        String connection = response.header("Connection");
        System.out.println("connection = " + connection);


        // get content type with header
        System.out.println("response.header(\"Content-Type\") = " + response.header("Content-Type"));

        // can we get connection() same as contentType() insteading of using header?
        // A --> Rest Assured created couple of method for common usage.
        // statusCode() contentType() methods are specificly created by them.So there is connection method


        // get date header
        System.out.println("response.header(\"Date\") = " + response.header("Date"));


        //how can we verify date is exist ?
        boolean isDateExist = response.headers().hasHeaderWithName("Date");

        Assertions.assertTrue(isDateExist);


        /*
         * Given accept  content type is application/json
         * When user sends GET request /api/spartans/3 endpoint
         * Then status code should be 200
         * And Content type should be application/json
         * And response body needs to contains Fidole
         */
    }
    @DisplayName("Get Single Spartan")
        @Test
                public void getSpartan() {

        Response response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get(url + "/api/spartans/3");

        Assertions.assertEquals("application/json", response.contentType());
        Assertions.assertEquals("application/json", response.header("Content-Type"));
        Assertions.assertEquals("application/json", response.header("Content-Type"));


        Assertions.assertTrue(response.body().asString().contains("Fidole"));

    }
            /*
        Given no headers provided
        When Users send GET request to /api/hello
        Then response status code should be 200
        And Content type header should be "text/plain;charset=UTF-8"
        And header should contain Date
        And Content-Length should be 17
        And body should be "Hello from Sparta"
    */

        @DisplayName("Get Hello Spartans")
        @Test
        public void HelloSpartans(){

            Response response = RestAssured
                    .given()
                    .accept(ContentType.JSON)
                    .when()
                    .get(url );

            int actualStatusCode = response.statusCode();
            Assertions.assertEquals(200, actualStatusCode);

        }

        @Test public void test2(){
//            String url="http://44.204.184.184:8000";
            Response response = RestAssured.get(url+"/api/spartans");
            int firstId = response.path("id[0]");
            System.out.println("firstId = " + firstId);

            String firstName = response.path("name[5]");
            System.out.println("firstName = " + firstName);
            
            String lastName = response.path("name[+1]");
            System.out.println("lastName = " + lastName);
            
           List<String>names =  response.path("name");
            System.out.println("names = " + names);

            List<Integer>id = response.path("id");
            System.out.println("id = " + id);

            List<Object >number = response.path("phone");
            System.out.print("number = " + number);
//            for (Object num : number){
//                System.out.println(num);
            }



            

}
