package org.example;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class RestAssured_demo_1 {
    public static void main(String[] args) {
        /*
        given() ====>  here we give content types, headers, username password, cookies etc.
        when()  ====>  after when and before then we give http method type
                get("https://reqres.in/api/users?page=2");  //this is hhp method type where we call api request
        then() ====>   here we validate the response like status code and data
        */

       /* syntax
       given().
       when().
            get(url end point).
       then();

        */

       Response res =  given().
                            when().
                                get("https://reqres.in/api/users?page=2");
        System.out.println(res.prettyPrint());

        System.out.println(res.statusCode());
        System.out.println(res.body().prettyPrint());


        if (res.statusCode() == 200){
            System.out.println("status code matched");
        }else{
            System.out.println("Status code not matched");
        }



        //given().
                when().
                get("https://reqres.in/api/users?page=2").
                then().statusCode(200);



    }
}
