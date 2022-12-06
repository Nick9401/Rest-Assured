package Cydeo.com.Day1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

public class Self {

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

}
