package com.travel.planner.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.travel.planner.DTO.Tour_req_dto; //요청 dto
import com.travel.planner.DTO.Tour_resp_dto; //응답 dto
import com.travel.planner.Domain.Tour_domain; //db의 entity
import com.travel.planner.Service.Tour_api_service; //관광 api
import com.travel.planner.Service.Tour_convert_service; //dto 변환
import com.travel.planner.Service.Tour_db_service;
import org.springframework.beans.factory.annotation.Autowired;  //공용객체 연결 import (repository, service ...)
import org.springframework.web.bind.annotation.*; //REST api 어노테이션 모음

import java.util.List;

@RestController //REST api 중 controller 선언
@RequestMapping("/tour") //기본 url : localhost:8080/tour
@CrossOrigin(origins = "*")

public class Tour_control {
    private final Tour_api_service api_service;
    private final Tour_db_service db_service;
    private final Tour_convert_service convert_service;

    public Tour_control(Tour_api_service api_service, Tour_db_service db_service, Tour_convert_service convert_service) {
        this.api_service = api_service;
        this.db_service = db_service;
        this.convert_service = convert_service;
    }
    /*
    @Autowired
    private Tour_api_service api_service;

    @Autowired
    private Tour_db_service db_service;

    @Autowired
    private Tour_convert_service convert_service;
    */
    //관광지 검색
    @GetMapping("/search") //Get 요청 : /tour/search?keyword=관광지
    public List<JsonNode> searchTour(
            @RequestParam String keyword
    ) {
        return api_service.callTourApi(keyword);
    }
    //여행 생성
    @PostMapping("/create") //Post요청 : /tour/create
    public Tour_resp_dto createTour(
            @RequestBody
            Tour_req_dto request //반환형이 tour_req_dto인 변수 request에 값을 담음
    ) {
        Tour_domain domain = convert_service.req_dto_asEntity(request);
        //domain에게 dto(request)의 entity 변환 값을 넘겨줌

        Tour_domain saved_domain = db_service.saveTour(domain);
        //db_service의 saveTour함수에 entity 변환값 전달한 반환값이 saved_domain

        Tour_resp_dto create_response = convert_service.entity_toRespDto(saved_domain);
        //saved_domain에 대한 dto 변환값 = response

        return create_response; //create요청에 대한 반환
    }
    //특정 여행 조회
    @GetMapping("/{userId}/{tourId}") //사용자1의 여행2 를 GET
    public Tour_resp_dto findTour(
            @PathVariable Long userId, @PathVariable Long tourId
    ) {
        Tour_domain find_domain = db_service.findTourById(userId, tourId); //db에서 값 찾기

        return convert_service.entity_toRespDto(find_domain); //dto로 변환
    }
    //전체 여행 조회
    @GetMapping("/all") // /tour/all
    public Object findAllTour() {
        return db_service.findAllTour();
    }
    //삭제
    @DeleteMapping("/{userId}/{tourId}")
    public String deleteTour(
         @PathVariable Long userId,
         @PathVariable Long tourId
    ) {
        db_service.deleteTour(userId, tourId);
        return "Deleted Successfully";
    }
}