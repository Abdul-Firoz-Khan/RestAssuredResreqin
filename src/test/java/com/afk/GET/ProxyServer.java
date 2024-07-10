package com.afk.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ProxyServer {
    @Test
    public void proxyServer(){

        RestAssured.given().proxy("127.0.0.1",8888).when().get("http://localhost:3000/blogpost").then().log().all();
    }
}
