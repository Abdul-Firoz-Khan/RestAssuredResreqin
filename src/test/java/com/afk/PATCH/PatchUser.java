package com.afk.PATCH;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class PatchUser {
    @Test()
    public void patchUser(){
        RestAssured.baseURI="https://reqres.in/api/users/2";
        String userData="{" + "\"name\": \"morpheus\","+ "\"job\": \"zion resident\""+ "}";

        given()
                .body(userData).when().patch()
                .then().log().all().assertThat()
                .statusCode(200) .body("updatedAt",is(notNullValue()));;




    }
}
