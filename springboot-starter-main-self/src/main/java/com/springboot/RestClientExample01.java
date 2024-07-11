package com.springboot;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class RestClientExample01 {
    public static void main(String[] args) {
        //n 객체 생성
        RestTemplate restTemplate =
                new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        //n URI 생성
        UriComponents uriComponents =
                UriComponentsBuilder
                        .newInstance() // UricomponentsBuilder 객체 생성
                        .scheme("http")// URI의 scheme 을 설정
                        .host("worldtimeapi.org")//호스트 정보를 입력
                        .port(80)// 디폴트 값은 80이므로 80포트를 사용하는 호스트면 생략 가능
                        .path("/api/timezone/{continents}/{city}")//URI의 경로를 입력
                        .encode()//URI에 사용된 템플릿 변수들을 인코딩해줌
                        .build();//UriComponents객체를 생성
        URI uri = uriComponents.expand("Asia", "Seoul").toUri();

        //n Request 전송
        String result = restTemplate.getForObject(uri,String.class);
        //getForObject()메서드는 HTTP Get요청을 통해 서버의 리소스 조회

        System.out.println(result);
    }
}
