package com.afk.DELETE;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser {
    @Test()
    public void deleteUser(){
        RestAssured.baseURI="https://reqres.in/api/users/2";
        given().when().delete().then().log().all().statusCode(204);
    }
}
