/*package com.travel.planner.Controller;

import com.travel.planner.Service.Recomm_service;
import com.travel.planner.DTO.Recomm_req_dto;
import com.travel.planner.DTO.Recomm_resp_dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController                                 //사용자 요청을 처리하는 controller 선언 - 반환값을 자동으로 JSON 변환
@CrossOrigin(origins = "*")                     //HTML(js)에서 spring 서버 접근 허용 ... 사실 '*'로 모든 주소 허용 (origin = 주소 + 포트) - Cross-Origin Resource Sharing 오류발생방지
@RequestMapping("/recomm")
public class Recomm_control {
    @Autowired
    private Recomm_service recomm_service;

    @PostMapping("/recommend")      //테마, 지역, 사용자 선택요소의 JSON 데이터 전달이 필요하기 때문에 POST
    public Recomm_resp_dto recommend(
            @RequestBody Recomm_req_dto dto //DTO에 요청한 JSON데이터를 dto객체에 담음
    ) {
        return Recomm_service.recommend(dto); //recomm_service에서 dto값으로 recommend 함수를 실행 시킨 값 반환
    }
}

 */