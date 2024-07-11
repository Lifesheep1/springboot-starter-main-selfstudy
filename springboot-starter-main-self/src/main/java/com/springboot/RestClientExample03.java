package com.springboot;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class RestClientExample03 {
    public static void main(String[] args) {
        RestTemplate restTemplate =
                new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        UriComponents uriComponents =
                UriComponentsBuilder
                        .newInstance()
                        .scheme("http")
                        .host("worldtimeapi.org")
                        .port(80)
                        .path("/api/timezone/{continents}/{city}")
                        .encode()
                        .build();
        URI uri = uriComponents.expand("Asia","Seoul").toUri();

        //Request 전송. exchange()를 사용한 일반화 된 방식
        ResponseEntity<WorldTime> response =
                restTemplate.exchange(uri, HttpMethod.GET,
                        null, WorldTime.class);
        //n exchange()메서드는 HTTP MEthond,RequestEntity,ResponseEntity를 직접 지정해서 HTTP Request를 전송할 수 있는 가장 일반적인 방식
        
        System.out.println("# datatime: " + response.getBody().getDatetime());
        System.out.println("# timezone: " + response.getBody().getTimezone());
        System.out.println("# day_of_week: " + response.getBody().getDay_of_week());
        System.out.println("# HTTP Status Code: " + response.getStatusCode());
        System.out.println("# HTTP Status Value: " + response.getStatusCodeValue());
    }
}
