package com.travel.planner.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.travel.planner.DTO.Recomm_req_dto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Recomm_service {
    private final Tour_api_service tour_api_service; //tour api service의 객체 생성

    public Recomm_service (Tour_api_service tour_api_service) {
        this.tour_api_service = tour_api_service;
    }

    public List<JsonNode> recommend(Recomm_req_dto dto) { //Recomm_req_dto의 요청내용 연결
        return tour_api_service.getRecommendTours( //tour_api_service의 getRecommendTours 함수와
                dto.getCity(),
                dto.getTheme(),
                dto.getProvince()
        );
    }
}
