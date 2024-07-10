package com.afk.POST;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class PostUser {
    @Test
    public void postUser(){
        RestAssured.baseURI="https://reqres.in/api/users";
        String userData="{" + "\"name\": \"morpheus\"," + "\"job\": \"leader\" " +"}";
        given().body(userData)
                .when()
                .post()
                .then().log().all().assertThat()
                .statusCode(201)
                .body("id",is(notNullValue()));
    }

}
