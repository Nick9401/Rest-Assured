package Cydeo.com.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BookTestBase {

    @BeforeAll
    public static void init() {

        RestAssured.baseURI = "https://api.qa.bookit.cydeo.com";
    }
    }
