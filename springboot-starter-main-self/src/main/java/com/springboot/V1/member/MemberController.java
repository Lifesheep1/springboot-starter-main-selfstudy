package com.springboot.V1.member;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController //n 해당 클래스가 REST API의 리소스를 처리하기 위한 API엔드포인트로 동작함을 정의
@RequestMapping(value = "/v1/members", produces = {MediaType.APPLICATION_JSON_VALUE})//핸들러 메서드를 매핑해주는 역할
public class MemberController {
    @PostMapping //n HTTP POST 요청을 처리하는 메서드임을 나타냅니다.
            //n `/v1/members`로 POST요청이 오면 이 메서드가 호출됩니다.
    public String postMember(@RequestParam("email") String email,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone)
            //n`postMember`메서드는 세 개의 요청 매개변수를 받습니다.
            //n`@RequestParam`어노테이션은 HTTP 요청의 파라미터를 메서드의 매개변수에 매핑합니다.
            //n`email`,`name`,`phone`이라는 요청 파라미터를 받아들이고, 각각의 값을 `String`타입의 `email`,`name`,`phone`변수에 할당합니다.

    {
        System.out.println("# email: " + email);
        System.out.println("# name: " + name);
        System.out.println("# phone: " + phone);
        //n 이 블록은 입력받은 email, name, phone 값을 콘솔에 출력합니다.

        String response =
                "{\"" +
                        "email\":\"" + email + "\"," +
                        "\"name\":\"" + name + "\"," +
                        "\"phone\":\"" + phone +
            "\"}";
        //n 입력받은 이메일,이름,폰 값을 JSON 형식의 문자열로 변환하여 response변수에 저장합니다.
        return response; //n  JSON형식의 문자열을 반환, 클라이언트에게 응답으로 전송됩니다.
    }

    @GetMapping("/{member-id}")
    //`@GetMapping`은 HTTP GET요청을 처리하는 메서드임을 나타냅니다.
    // `/v1/members/{member-id}`로 GET요청이 오면 이 메서드가 호출됩니다. `member-id`는 URL 경로 변수입니다.
    public String getMember(@PathVariable("member-id")long memberId){
        System.out.println("# memberId: " + memberId);
        //`getMember`메서드는 `member-id`경로 변수를 매개변수`memberId`에 매핑합니다.
        //`@PathVariable` 어노테이션을 사용하여 URL경로에서 값을 추출합니다.
        //추출된 memberId값을 콘솔에 출력합니다.

        //not implementation
        return null;
        //아직 이 메서드는 구현되지않았으며 null값 반환
    }

    @GetMapping
    //이 어노테이션은 매개변수가 없는 HTTP GET요청을 처리하는 메서드입니다.
    //`/v1/members`로 GET요청이 오면 이 메서드가 호출됩니다.
    public String getMembers(){
        System.out.println("# get Members");
        //getMembers라는 메시지를 콘솔에 출력합니다

        //not implementation
        return null;
        //아직 이 메서드는 구현되지않았으며 null값 반환
    }
}
