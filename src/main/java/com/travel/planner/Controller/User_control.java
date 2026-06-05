package com.travel.planner.Controller;

import com.travel.planner.DTO.User_req_dto;
import com.travel.planner.DTO.User_resp_dto;
import com.travel.planner.Service.User_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController                                 //사용자 요청을 처리하는 controller 선언 - 반환값을 자동으로 JSON 변환
@CrossOrigin(origins = "*")                     //HTML(js)에서 spring 서버 접근 허용 ... 사실 '*'로 모든 주소 허용 (origin = 주소 + 포트) - Cross-Origin Resource Sharing 오류발생방지
@RequestMapping("/user")
public class User_control {
    @Autowired
    private User_service user_service;      //User_service에 객체 요청

    @PostMapping("/welcome")                //url에 /welcome붙여서 db에 값 저장 시작
    public Long welcome(
            @RequestBody User_req_dto request   //request변수에 User_req_dto 객체 담아옴
    ) {
        return user_service.Check(request);   //반환 내용을 User_service 주소의 변수에 반환
    }
    @PostMapping("/login")
    public User_resp_dto login(
            @RequestBody User_req_dto request
    ) {
        return user_service.loginVerify(request.getLoginId(), request.getLoginPassword());
    }
}

