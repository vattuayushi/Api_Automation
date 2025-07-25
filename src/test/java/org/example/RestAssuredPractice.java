package org.example;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RestAssuredPractice {


    @Test
    public void m1(){
        given().
                when().
                get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200);
    }

    @Test(description = "Creating New Resource")
    public void m2(){

        String payload = "   {\n" +
                "           \"name\": \"morpheus\",\n" +
                "            \"job\": \"leader\"\n" +
                "    }\n";


        given().
                contentType(ContentType.JSON)
                .body(payload)
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .statusCode(201);







    }
}
