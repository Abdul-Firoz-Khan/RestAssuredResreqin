package com.afk.POST;

import com.afk.model.ReqresInPOJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class ReqresInPOJOCreateUserTest {
    private static final ObjectMapper mapper= new ObjectMapper();
    @Test
    public void createUserTest() throws JsonProcessingException {
        ReqresInPOJO reqresInPOJO= new ReqresInPOJO();

        reqresInPOJO.setName("John Doe");
        reqresInPOJO.setJob("Software Engineer");
        String url= "https://reqres.in/api/users";
        String json = mapper.writeValueAsString(reqresInPOJO);
        // Create a new user
        RestAssured.given()
                .body(json)
                .when()
                .post(url)
                .then()
                .statusCode(201).body("id",is(notNullValue())); // Assuming 201 is the expected status code for successful creation
    }
}
