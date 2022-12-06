package Cydeo.com;

import Cydeo.com.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class HomeWork extends HrTestBase {

//- Given accept type is Json
//- Path param value- US
//- When users sends request to /countries
//- Then status code is 200
//- And Content - Type is Json
//- And country_id is US
//- And Country_name is United States of America
//- And Region_id is 2

    @DisplayName("Get Countries")
    @Test

    public void test1() {

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("country_id", "US")
                .when().get("/countries/{country_id}");

        JsonPath jp = response.jsonPath();
        //  response.prettyPrint();
        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertEquals("US", jp.getString("country_id"));
        assertEquals("United States of America", jp.getString("country_name"));
        assertEquals(2, jp.getInt("region_id"));
    }


    @DisplayName("Get Countries")
    @Test

    public void test2() {
//        - Given accept type is Json
//        - Query param value - q={"department_id":80}
//        - When users sends request to /employees

//        - Then status code is 200
//        - And Content - Type is Json
//        - And all job_ids start with 'SA'
//        - And all department_ids are 80
//        - Count is 25
        Response response = given().accept(ContentType.JSON)
                .queryParam("q", "{\"department_id\":80}")
                .get("/employees");
        JsonPath js = response.jsonPath();
        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());
        List<String>jobId = js.getList("items.job_id");
        for (String each : jobId) {
            assertTrue(each.startsWith("SA"));






        }


    }
}