package Cydeo.com.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class SpartanTestBase {
    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://44.204.184.184:8000";
    }

}
