package Cydeo.com.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class HrTestBase {

        @BeforeAll
        public static void init(){

            RestAssured.baseURI="https://api.training.cydeo.com";



    }
}