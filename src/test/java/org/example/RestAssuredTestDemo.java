package org.example;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredTestDemo {

    /***
     * @Test params
     * description -> for test description
     * priority -> to decide which test to tun first
     * skip test -> use enabled = false
     */
    @Test(priority = 1)
    public void getUserTest(){
        given().
                when().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200);
    }

    @Test
    public void checkStatusCodeUsingAssertion(){
        Response response = given().
                header("x-api-key"," reqres-free-v1").
                when().
                get("https://reqres.in/api/users?page=2");

        int actualResponse = response.statusCode();
        System.out.println(actualResponse);
        int expectedResponse = 200;
        assert actualResponse == expectedResponse;
        assert "shubham".contains("bhuu");
    }


    @Test(description = "Validating Status Code", priority = 2)
    public void testStatusCode(){
        given().when().get("https://reqres.in/api/users?page=2").then().statusCode(301);
    }


    @Test
    public void sum(){
        int a = 4;
        assert (a == 4);
    }


}
