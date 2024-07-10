package com.afk.GET;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetUser {

    @Test
    @Owner("AFK")
    @Severity(SeverityLevel.NORMAL)
    @Description("Varify The Status Code 200")

    public void getUser() {
        setUp();
        Response response = sendGetRequest();
        validateResponse(response);
    }

    @Step("Set up the base URI")
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in/api/users";
    }

    @Step("Send GET request to fetch users")
    public Response sendGetRequest() {
        return given()
                .queryParam("page", "2")
                .when()
                .get()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("page", equalTo(2))
                .extract().response();
    }

    @Step("Validate the response")
    public void validateResponse(Response response) {
        // Additional validation steps can be added here
    }
}
