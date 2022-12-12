package Cydeo.day06;

import Cydeo.com.utilities.Driver;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;
//
//public class formula1ConstractorsTest {
//    Response response = given().accept(ContentType.JSON)
//            .pathParam("driverID", "alonso")
//            .get("/drivers/{driverID}.json").prettyPeek()
//            .then()
//            .log().ifValidationFails()
//            .statusCode(200)
//            .contentType("application/json; charset=utf-8")
//            .body("MRData.DriverTable.Drivers[0].givenName", is("Fernando"))
//            .body("MRData.DriverTable.Drivers[0].familyName", is("Alonso"))
//            .body("MRData.DriverTable.Drivers[0].nationality", is("Spanish"))
//            .extract().response();
//    ;
//
//    // first Way - hamcrest
//    String actualFirstNameHC = response.path("MRData.DriverTable.Drivers[0].givenName");
//
//    assertThat(actualFirstNameHC, is("Fernando"));
//
//    String actualLastNameHC = response.path("MRData.DriverTable.Drivers[0].familyName");
//
//    assertThat(actualLastNameHC, is("Alonso"));
//
//    String actualNationHC = response.path("MRData.DriverTable.Drivers[0].nationality");
//
//    assertThat(actualNationHC, is("Spanish"));
//
//
//    // second way - regular assertion by the RESPONSE
//
//    String actualFirstName = response.path("MRData.DriverTable.Drivers[0].givenName");
//        Assertions.assertEquals("Fernando",actualFirstName);
//
//    String actualLastName = response.path("MRData.DriverTable.Drivers[0].familyName");
//        Assertions.assertEquals("Alonso",actualLastName);
//
//    String actualNation = response.path("MRData.DriverTable.Drivers[0].nationality");
//        Assertions.assertEquals("Spanish",actualNation);
//
//
//    // Third way - regular assertion by the JsonPath
//    JsonPath jsonPath = response.jsonPath();
//
//    String actualFirstNameJP = jsonPath.getString("MRData.DriverTable.Drivers[0].givenName");
//        Assertions.assertEquals("Fernando",actualFirstNameJP);
//
//    String actualLastNameJP = jsonPath.getString("MRData.DriverTable.Drivers[0].familyName");
//        Assertions.assertEquals("Alonso",actualLastNameJP);
//
//    String actualNationalityJP = jsonPath.getString("MRData.DriverTable.Drivers[0].nationality");
//        Assertions.assertEquals("Spanish",actualNationalityJP);
//
//
//    // Forth way - regular assertion by the POJO
//    Driver driver = jsonPath.getObject("MRData.DriverTable.Drivers[0]", Driver.class);
//
//        Assertions.assertEquals("Fernando",driver.getFirstName());
//        Assertions.assertEquals("Alonso",driver.getLastName());
//        Assertions.assertEquals("Spanish",driver.getNationality());
//
//}
//
//    @Test
//    public void test2() {
//
//        Response response = given().accept(ContentType.JSON)
//                .get("/constructors.json").prettyPeek()
//                .then()
//                .log().ifValidationFails()
//                .statusCode(200)
//                .contentType("application/json; charset=utf-8")
////                .body("MRData.DriverTable.Drivers[0].givenName", is("Fernando"))
////                .body("MRData.DriverTable.Drivers[0].familyName", is("Alonso"))
////                .body("MRData.DriverTable.Drivers[0].nationality", is("Spanish"))
//                .extract().response();
//        ;
//
//
//    }
//}