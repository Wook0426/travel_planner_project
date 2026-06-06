package com.travel.planner.Service;

import com.fasterxml.jackson.databind.JsonNode; //파싱된 JSON 객체를 다루게 해줌
import com.travel.planner.Domain.Place_domain; //자식 클래스 인용
import com.travel.planner.Repository.Place_repo; //db접근 명령을 위한 db접근 주체 클래스 인용
import org.springframework.stereotype.Service; //클래스 역할 명시
import org.springframework.transaction.annotation.Transactional; // 기입 사항이 완성되어야만 db를 호출하는 어노테이션 transactional

public class Place_service {
    private final Place_repo placeRepo;

    public Place_service(Place_repo placeRepo) {
        this.placeRepo = placeRepo; //db 접근을 위한 repository 객체 생성
    }

    @Transactional
    public Long saveFromApi(JsonNode item) {
        Place_domain place = new Place_domain();
        place.setPlaceName(item.path("title").asText());
        place.setPlaceAddress(item.path("addr1").asText());
        place.setImageUrl(item.path("firstimage").asText());
        place.setPlaceDescription(item.path("cat1").asText());
        return placeRepo.save(place).getPlaceId();
    }
}

