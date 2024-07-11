package com.springboot.V2.member;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController // 해당 클래스가 REST API의 리소스를 처리하기 위한 API 엔드포인트로 동작함을 정의
@RequestMapping(path = "/v2/members")// produces 설정 제거됨
public class MemberController_v2 {
    @PostMapping // HTTP POST 요청을 처리하는 메서드임을 나타냅니다.
            // `/v1/members`로 POST요청이 오면 이 메서드가 호출됩니다.
    public ResponseEntity postMember(@RequestParam("email") String email,
                                     @RequestParam("name") String name,
                                     @RequestParam("phone") String phone)
            //`postMember`메서드는 세 개의 요청 매개변수를 받습니다.
            //`@RequestParam`어노테이션은 HTTP 요청의 파라미터를 메서드의 매개변수에 매핑합니다.
            //`email`,`name`,`phone`이라는 요청 파라미터를 받아들이고, 각각의 값을 `String`타입의 `email`,`name`,`phone`변수에 할당합니다.

    {
//        // JSON 문자열 수작업을 Map 객체로 대체
//        for (Map.Entry<String, String> entry : headers.entrySet()){
//            System.out.println("key: " + entry.getKey() +
//                    ", value: " + entry.getValue());
//        }
        //위치 정보를 헤더에 추가
        HttpHeaders headers = new HttpHeaders();
        headers.set("Client-Geo-Location", "Korea,Seoul");

        // 리턴 값을 ResponseEntity 객체로 변경
        return new ResponseEntity<>(new Member(email,name,phone), HttpStatus.CREATED);
    }

    @GetMapping("/{member-id}")
    //`@GetMapping`은 HTTP GET요청을 처리하는 메서드임을 나타냅니다.
    // `/v1/members/{member-id}`로 GET요청이 오면 이 메서드가 호출됩니다. `member-id`는 URL 경로 변수입니다.
    public ResponseEntity getMember(@PathVariable("member-id")long memberId){
        System.out.println("# memberId: " + memberId);
        //`getMember`메서드는 `member-id`경로 변수를 매개변수`memberId`에 매핑합니다.
        //`@PathVariable` 어노테이션을 사용하여 URL경로에서 값을 추출합니다.
        //추출된 memberId값을 콘솔에 출력합니다.

        //not implementation

        //n 리턴 값을 ResponseEntity 객체로 변경
        return new ResponseEntity<>(HttpStatus.OK);
        //아직 이 메서드는 구현되지않았으며 null값 반환
    }

    @GetMapping
    //이 어노테이션은 매개변수가 없는 HTTP GET요청을 처리하는 메서드입니다.
    //`/v1/members`로 GET요청이 오면 이 메서드가 호출됩니다.
    public ResponseEntity getMembers(HttpServletResponse response){
        response.addHeader("Client-Geo-Location", "Korea,Seoul");
        //아직 이 메서드는 구현되지않았으며 null값 반환
        return null;
    }
}
