package Cydeo.com.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class Driver {


    @BeforeAll
    public static void init(){

        RestAssured.baseURI="http://ergast.com/mrd/methods/\n" +
                "    drivers/";
}}
