package com.afk.GET;

import org.asynchttpclient.Dsl;
import org.asynchttpclient.Response;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncDemo {


    @Test()
    public void AsyncDemo() throws ExecutionException, InterruptedException {
        Future<Response> responseFuture = Dsl.asyncHttpClient()
                .prepareGet("https://reqres.in/api/users?delay=3").execute();
        Response response = responseFuture.get();
        System.out.println("response = " + response);
        System.out.println("Response StatusCode = " + response.getStatusCode());
    }

}
