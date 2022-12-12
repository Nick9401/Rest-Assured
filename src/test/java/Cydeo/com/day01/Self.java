package Cydeo.com.day01;

import Cydeo.com.utilities.SpartanTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

public class Self extends SpartanTestBase {

    @BeforeClass
    public void setUpClass() {
        RestAssured.baseURI = "http://44.204.184.184:8000";
    }
    String url="http://44.204.184.184:8000";
    @Test
    public void SEL(){

        Response response = RestAssured.get(url + "/api/spartans");

        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.body().asString() = " + response.body().prettyPrint());
    }

    @Test
    public void test(){
        Response response = RestAssured.get(url + "/api/spartans");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertTrue(response.body().asString().contains("Allen"));

    }

    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(url + "/api/spartans");

        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.contentType(),"application/json");


    }





@Test
    public void QueryParam1(){
    RestAssured.baseURI = "http://44.204.184.184:8000";
    Response response = RestAssured.given().accept(ContentType.JSON)
            .queryParam("geneder", "Female")
            .queryParam("nameContains", "J")
            .get("/api/spartans/search");

    Assertions.assertEquals(response.statusCode(),200);
    Assertions.assertEquals(response.contentType(),"application/json");
    Assertions.assertTrue(response.body().asString().contains("Female"));
    Assertions.assertTrue(response.body().asString().contains("Janette"));
    response.prettyPrint();



}
@Test
    public void queryParam2(){
    RestAssured.baseURI = "http://44.204.184.184:8000";
    Map<String,Object>paramsMap=new HashMap<>();
    paramsMap.put("gender","Female");
    paramsMap.put("nameContains","J");

    Response response = RestAssured.given().accept(ContentType.JSON)
            .queryParam(String.valueOf(paramsMap))
            .get("/api.spartans/search");

    Assertions.assertEquals(response.statusCode(),200);
    Assertions.assertEquals(response.contentType(),"application/json");
    Assertions.assertTrue(response.body().asString().contains("Female"));
    Assertions.assertTrue(response.body().asString().contains("Janette"));
    response.prettyPrint();
}

@Test
    public void Test1(){
    RestAssured.baseURI = "http://44.204.184.184:8000";
    Response response = RestAssured.given().accept(ContentType.JSON)
            .pathParams("id",10)
            .get("/api/spartans/{id}");

    Assertions.assertEquals(response.statusCode(),200);
    Assertions.assertEquals(response.contentType(),"application/json");

    System.out.println("'ID= " + response.body().path("id").toString());
    System.out.println("'NAME= " + response.body().path("name").toString());
    System.out.println("'gender= " + response.body().path("gender").toString());
    System.out.println("'Phone= " + response.body().path("phone").toString());

    int id = response.path("id");
    String name = response.body().path("name");
    long phone = response.path("phone");
    String gender = response.path("gender");

    System.out.println("phone = " + phone);
    System.out.println("name = " + name);
    System.out.println("id = " + id);
    System.out.println("gender = " + gender);

    Assertions.assertEquals(id,10);
    Assertions.assertEquals(name,"Lorenza");
    Assertions.assertEquals(phone,3312820936l);
    Assertions.assertEquals(gender,"Female");
}

@Test
    public void test7(){

    Response response = given().accept(ContentType.JSON)
            .pathParams("id", 11)
            .when().get(".api/spartans/{id}");
    assertEquals(response.statusCode(),200);
    int id = response.path("id");
    System.out.println("id = " + id);

    JsonPath jsonPath = response.jsonPath();

    int id1 = jsonPath.getInt("id");
    String name = jsonPath.getString("name");
    String gender = jsonPath.getString("gender");
    long phone = jsonPath.getLong("phone");


}
@Test
    public void test5(){
        given().accept(ContentType.JSON)
                .pathParams("id",15)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200).and()
                .assertThat().contentType("application/json");
}

@Test
    public void test4(){
        given().accept(ContentType.JSON)
                .pathParams("id",15)
                .when().get("/api/spartans/{id}")
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("id", Matchers.equalTo(15),"name",Matchers.equalTo("Meta"),
    "gender",Matchers.equalTo("Female"),"phone",Matchers.equalTo(1938695106));
}

@Test
    public void test6(){
    Response response= given().accept(ContentType.JSON)
            .pathParams("id",11)
            .and().when().get("/api/spartans/{id}");

   Map<String,Object>spartanMap= response.body().as(Map.class);
    System.out.println("spartanMap = " + spartanMap.get("name"));
    System.out.println("spartanMap = " + spartanMap.get("id"));
    System.out.println("spartanMap = " + spartanMap.get("gender"));

}

//deserialization

   @Test
    public void test8(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");

        response.prettyPrint();
        List<Map<String,Object>> listOfSpaertans = response.body().as(List.class);

        //Print all data of first Spratan
       System.out.println("listOfSpaertans.get(0) = " + listOfSpaertans.get(0));
       Map<String,Object> firstSpartan = listOfSpaertans.get(0);

       int counter =1;
       for(Map<String,Object>map : listOfSpaertans){
       System.out.println(counter+" - spratan " + map);
       counter++;

   }



}}
