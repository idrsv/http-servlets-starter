package com.idrsv.http.client;

import java.io.IOException;
import java.net.URL;

public class UrlExample {
    public static void main(String[] args) throws IOException {
        var url = new URL("file:/Users/idrsv/Desktop/http-servlets-serter/src/main/java/com/idrsv/http/socket/DatagramRunner.java");
        var urlConnection = url.openConnection();

        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }

    private static void checkGoogle() throws IOException {
        var url = new URL("https://www.google.com");//адрес по которому мы будем обращаться
        var urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);
        try (var outputStream = urlConnection.getOutputStream()) {

        }
    }
}
