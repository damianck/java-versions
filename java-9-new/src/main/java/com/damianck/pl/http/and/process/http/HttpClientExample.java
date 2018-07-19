package com.damianck.pl.http.and.process.http;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.io.IOException;
import java.net.URI;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request =
                HttpRequest.newBuilder(URI.create("https://www.pluralsight.com"))
                        .GET()
                        .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandler.asString());

        if(response.statusCode() == 200)
            System.out.println(response.headers().map());

    }
}
