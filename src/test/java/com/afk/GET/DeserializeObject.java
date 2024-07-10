package com.afk.GET;

import com.afk.model.BlogpostPOJO;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static io.restassured.RestAssured.given;

public class DeserializeObject {


    @Test
    public void DeserializeObject() throws IOException {

        String url = "http://localhost:3000/blogpost/3";
        Response response = RestAssured.given().when().get(url);
        BlogpostPOJO responseObject = response.as(BlogpostPOJO.class);
        System.out.println("responseObject " + responseObject.toString());

        String url1 = "http://localhost:3000/blogpost";  // Ensure this endpoint returns the correct JSON
        Response response1 = RestAssured.given().when().get(url1);
        // Print the raw response body for debugging
        String responseBody = response1.getBody().asString();
        byte[] bytes= response1.getBody().asByteArray();
        File file =new File("C:/Users/lenovo/Downloads/user.json");
        Files.write(file.toPath(),bytes);
        System.out.println("Raw response body: " + responseBody);




        }
    }

