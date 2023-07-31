package com.java.study.practical.ch11;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpGetExample {

    public static void main(String[] args) {
        String url = "https://fpbc.nongsu.co.kr/code/parent/flower";

        // HttpRequest를 정의
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
//                .header("Content-Tpye", "application/json")
                .GET()
                .build();

        // HttpClient 객체를 생성한다
        HttpClient httpClient = HttpClient.newHttpClient();

        // 요청을 호출한다

        try {

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            int statusCode = httpResponse.statusCode();
            System.out.println("statusCode = " + statusCode);

            HttpHeaders headers = httpResponse.headers();
            System.out.println("headers = " + headers);

            String body = httpResponse.body();
            System.out.println("body = " + body);

            ObjectMapper mapper = new ObjectMapper();

            List<Code> codes = mapper.readValue(body, new TypeReference<List<Code>>() {});
            for (Code code : codes) {
                System.out.println("code = " + code);
            }



        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
