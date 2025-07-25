package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RestAssuredPractice {


    @Test
    public void getRequest(){
       Response res1 =  given().
                when().
                get("https://reqres.in/api/users?page=2");
       int expectedresponse = 200;
       int actualResponse = res1.statusCode();
        System.out.println("Status code of 1st get method is : " + actualResponse);
        //assert expectedresponse == actualResponse;
        Assert.assertEquals(actualResponse, expectedresponse);
    }

    @Test(description = "Creating New Resource")
    public void postRequest(){

        String payload = "   {\n" +
                "           \"name\": \"morpheus\",\n" +
                "            \"job\": \"leader\"\n" +
                "    }\n";

        given().
                contentType(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1")
                .body(payload)
                .when()
                    .post("https://reqres.in/api/users")
                .then()
                    .statusCode(201);

    }
    @Test(description = "Updating the user details")
    public void putRequest(){
        String updatePayload =  " {\n" +
                "           \"name\": \"Salman\",\n" +
                "            \"job\": \"Khan\"\n" +
                "    }\n";

       Response newresponse = given()
                .contentType(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1")
                .body(updatePayload)
                .when()
                    .put("https://reqres.in/api/users/2");
        String updatedresponse = newresponse.asPrettyString();
        System.out.println("Details of Updated User:   " + updatedresponse);

        int actualcode = 201;
        int Updatedcode = newresponse.statusCode();
        System.out.println("Status Code Of Put Request :  "  +  Updatedcode);


        System.out.println(newresponse.jsonPath().getString("updatedAt"));

        String updated_username = newresponse.jsonPath().getString("name");
        Assert.assertEquals(updated_username, "Shubham");


    }

    @Test(description = "Deleting user")
        public void delete(){
        given()
                    .header("x-api-key", "reqres-free-v1")
                .when()
                    .delete("https://reqres.in/api/users/2")
                .then()
                    .statusCode(204);
    }
}
