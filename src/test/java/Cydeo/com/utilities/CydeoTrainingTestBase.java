package Cydeo.com.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CydeoTrainingTestBase {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI="https://api.training.cydeo.com";
   }

}
