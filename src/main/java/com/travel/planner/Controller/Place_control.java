package com.travel.planner.Controller;      //controller는 "입구" 역할 수행함

import com.fasterxml.jackson.databind.JsonNode;
import com.travel.planner.DTO.Place_resp_dto;     //서로다른 패키지의 클래스 접근은 import 요구됨
import com.travel.planner.DTO.Place_req_dto;
import com.travel.planner.Service.Tour_api_service;   //    "

import org.springframework.beans.factory.annotation.Autowired;  //spring에게 @객체 자동 연결 요청 (spring이 관리하는 객체 : bean)
import org.springframework.web.bind.annotation.*;   //spring 웹 기능 전체(*) 사용

import java.util.List;

/*
[spring 웹 기능]
    @RestController	    컨트롤러 지정
    @GetMapping	GET     요청 처리
    @PostMapping	    POST 요청 처리
    @RequestParam	    URL 값 받기
    @RequestBody	    JSON 데이터 받기
    @CrossOrigin	    브라우저 접근 허용
    @RequestMapping	    공통 URL
 */
@RestController                                 //사용자 요청을 처리하는 controller 선언 - 반환값을 자동으로 JSON 변환
@CrossOrigin(origins = "*")                     //HTML(js)에서 spring 서버 접근 허용 ... 사실 '*'로 모든 주소 허용 (origin = 주소 + 포트) - Cross-Origin Resource Sharing 오류발생방지
@RequestMapping("/tour")                        //공통 url 연결 요청 ("/tour" + /search or /list or ...)
public class Place_control {
    @Autowired
    //서버에게 Tour_service의 객체 요청 (@service/Tour_service 발견시 서버가 자동으로 new Tour_service()생성)
    private Tour_api_service tour_api_service;          //그 객체 주소를 tour_service 변수에 삽입

    @PostMapping("/search")                      //Post 요청 처리 (Request + Post) : 문자열 반환
    public List<JsonNode> searchPlace(
            @RequestBody Place_req_dto request
    ) {
        return tour_api_service.callTourApi(request.getPlaceName());
    }
    /*
    public Place_resp_dto searchPlace(@RequestParam String keyword) {   //DTO 객체 반환함수(url 값 인계 - 문자열 keyword 해당값)
        Place_resp_dto result = tour_service.searchPlace(keyword); //DTO 객체 result = Tour_service 객체 주소 + 인계값 keyword => 구체적인 url 완성

        return result;
    }
     */
}
