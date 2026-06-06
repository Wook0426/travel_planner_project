package com.travel.planner.Service;

import com.travel.planner.Domain.Tour_domain;
import com.travel.planner.Domain.User_domain;
import com.travel.planner.DTO.Tour_req_dto;
import com.travel.planner.DTO.Tour_resp_dto;
import com.travel.planner.Repository.User_repo;
import com.travel.planner.Rule.IsNull_rule;
import org.springframework.stereotype.Service;

@Service
public class Tour_convert_service {
    private final User_repo userRepo;// @ManyToOne으로 선언된 필드는 JPA가 객체 참조로만 받기 때문에 Long을 그대로 넣을 수 없어서 한 번 DB 조회를 거친다.

    public Tour_convert_service(User_repo userrepo) {
        this.userRepo = userrepo;
    }

    public Tour_domain req_dto_asEntity(Tour_req_dto request) { //요청 dto를 entity로 변환
        Tour_domain domain = new Tour_domain(); //변환된 실질 값을 담는 객체 생성

        User_domain user = userRepo.findById(request.getUserId()).orElse(null);
        IsNull_rule.NullCheck(user,"해당 사용자가 존재하지 않습니다.");
        domain.setUserId(user);

        domain.setTourId(request.getTourId()); //어느 여행인가
        domain.setTourType(request.getTourType()); //무슨 여행인가
        domain.setHowMany(request.getHowMany()); //몇명이 가는가
        domain.setTourName(request.getTourName()); //여행명
        domain.setStartDate(request.getStartDate()); //언제 가는가
        domain.setEndDate(request.getEndDate()); //언제 오는가

        return domain;
    }
    public Tour_resp_dto entity_toRespDto(Tour_domain domain) {
        Tour_resp_dto response = new Tour_resp_dto();

        response.setUserId(domain.getUserId().getUserId()); //User_domain 객체 -> Long userId로 세팅
        response.setTourId(domain.getTourId());
        response.setTourType(domain.getTourType());
        response.setHowMany(domain.getHowMany());
        response.setTourName(domain.getTourName());
        response.setStartDate(domain.getStartDate());
        response.setEndDate(domain.getEndDate());

        return response;
    }
}
