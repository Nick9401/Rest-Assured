package Cydeo.com.Day05_HamCrestMatchers;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matcher.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class P01_HamCrestMatchersIntro {

    @Test
    public void numbers() {
        // it comes from Junit5 to make assertions
        assertEquals(9,3+6);

        // Hamcrest Matchers comes from RestAssured dependency
        // import static org.hamcrest.MatcherAssert.*;
        // import static org.hamcrest.Matchers.*;
        // Adding following static import we are not gonna us classnames
        // while we are calling method from related classes
        // Matchers hs 2 overloaded methods
        // - First one will take value to check
        // - Second one will take another Matcher to make it readable / to add new assert functionality
        assertThat(9, is(6+3));
        assertThat(9,is(equalTo(6+3)));
        assertThat(9,equalTo(6+3));

        /**
         * is(someValue)
         * is(equalTo(someValue))
         * equalTo(someValue)
         * All of them same in terms of assertion
         */

        assertThat(5+5,not(9));
        assertThat(5+5,is(not(9)));
        assertThat(5+5,is(not(equalTo(9))));

        /**
         * These 3 are same again
         */


        /**
         * greaterThan() lessThan()
         * greaterThanOrEqualTo() lessThanOrEqualTo()
         */

        assertThat(5+6,is(greaterThan(10)));
        assertThat(5+6,greaterThan(10));
        assertThat(5+5,lessThanOrEqualTo(10));

    }


    @Test
    public void testStrings() {
        // so first will be actual result in this case right?
        // Yes for now.but while we are implementing in then sections we are gonna send actual as we did in here
        // it will read data from response under the hood


        String msg="API is fun!";

        assertThat(msg,is("API is fun!"));
        assertThat(msg,equalTo("API is fun!"));
        assertThat(msg,equalToIgnoringCase("api is fun!"));

        assertThat(msg,startsWith("API"));
        assertThat(msg,startsWithIgnoringCase("api"));

        assertThat(msg,endsWith("fun!"));
        assertThat(msg,endsWithIgnoringCase("FUN!"));

        assertThat(msg,containsString("is"));
        assertThat(msg,containsStringIgnoringCase("IS"));

        assertThat(msg,not("Fun!"));
        assertThat(msg,is(not("Fun!")));
    }
}