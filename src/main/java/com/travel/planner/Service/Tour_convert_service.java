package com.travel.planner.Service;

import com.travel.planner.Domain.Tour_domain;
import com.travel.planner.DTO.Tour_req_dto;
import com.travel.planner.DTO.Tour_resp_dto;
import org.springframework.stereotype.Service;

@Service
public class Tour_convert_service {
    public Tour_domain req_dto_asEntity(Tour_req_dto request) { //요청 dto를 entity로 변환
        Tour_domain domain = new Tour_domain(); //변환된 실질 값을 담는 객체 생성

        domain.setUserId(request.getUserId()); //어떤 사용자인가
        domain.setTourId(request.getTourId()); //어느 여행인가
        domain.setTourType(request.getTourType()); //무슨 여행인가
        domain.setHowMany(request.getHowMany()); //몇명이 가는가
        domain.setTourName(request.getTourName()); //여행명

        return domain;
    }
    public Tour_resp_dto entity_toRespDto(Tour_domain domain) {
        Tour_resp_dto response = new Tour_resp_dto();

        response.setUserId(domain.getUserId());
        response.setTourId(domain.getTourId());
        response.setTourType(domain.getTourType());
        response.setHowMany(domain.getHowMany());
        response.setTourName(domain.getTourName());

        return response;
    }
}
