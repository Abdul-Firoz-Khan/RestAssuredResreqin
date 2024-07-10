package com.afk.POST;

import com.afk.model.BlogpostPOJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SerializeObject {
    private static final ObjectMapper mapper= new ObjectMapper();

        @Test()
    public void SerializeObject() throws JsonProcessingException {
            BlogpostPOJO bp1= new BlogpostPOJO();
            bp1.setId(9);
            bp1.setAuthor("Rajesh");
            bp1.setTitle("Arora");
            String url="http://localhost:3000/blogpost";
            String json = mapper.writeValueAsString(bp1);
            Response response= RestAssured.given().contentType("application/json")
                    .log().all(true).body(json).post(url).andReturn();
            assertEquals(response.getStatusCode(),201,"Http Message");

    }
}
