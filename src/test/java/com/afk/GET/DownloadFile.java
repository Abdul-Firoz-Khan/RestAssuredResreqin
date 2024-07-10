package com.afk.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class DownloadFile {


    @Test
    public void DownloadFile() throws IOException {

        String url = "http://localhost:3000/blogpost";  // Ensure this endpoint returns the correct JSON
        Response response = RestAssured.given().when().get(url);
        // Print the raw response body for debugging
        String responseBody = response.getBody().asString();
        byte[] bytes= response.getBody().asByteArray();
        File file =new File("C:/Users/lenovo/Downloads/blogpost.json");
        Files.write(file.toPath(),bytes);
        System.out.println("Raw response body: " + responseBody);




    }
}

