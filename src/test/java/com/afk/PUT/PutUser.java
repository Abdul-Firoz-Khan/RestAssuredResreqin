package com.afk.PUT;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class PutUser {
    @Test()
    public void putUser() {
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        String UserData = "{" + "\"name\": \"morpheus\"," + "\"job\": \"zion resident\" " + "}";
        given().body(UserData).when().patch().then()
                .log().all().assertThat().statusCode(200)
                .body("updatedAt", is(notNullValue()));
    }
}
