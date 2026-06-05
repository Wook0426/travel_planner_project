package com.travel.planner.Controller;
/*
import com.travel.planner.Service.Daily_service;
import com.travel.planner.DTO.Daily_resp_dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;                              // java list 자료형 사용

@RestController
@CrossOrigin(origins = "*")                     //HTML(js)에서 spring 서버 접근 허용 ... 사실 '*'로 모든 주소 허용 (origin = 주소 + 포트) - Cross-Origin Resource Sharing 오류발생방지
@RequestMapping("/daily")                       // "
public class Daily_control {
    @Autowired
    private Daily_service daily_service;        //daily_service의 객체를 Daily_service에 요청

    @GetMapping("/list")
    public List<Daily_resp_dto> getplanList() {     // list로 DTO 여러 개 반환
        return daily_service.getplanList();
    }
    @PostMapping("/save")       //db 데이터저장 접근이 발생하기 때문에 POST 사용
    public Daily_resp_dto savePlan (
            @RequestBody Daily_resp_dto request //http body 내부에서 JSON 전체 추출
    ) {
        return daily_service.savePlan(requset); // 사용자 입력 전체 삽입
    }
    @PutMapping("/modify/{id}")     //url 마지막 id값 인식
    public Daily_resp_dto modifyPlan (
            @PathVariable Long id,      //url값을 변수로 추출 -> 특정 column 접근
            @RequestBody Daily_resp_dto request // 변경할 내용(Daily_req_dto) 가져옴
    ) {
        return daily_service.modifyPlan(id, request); //변경된 데이터 삽입
    }
    @DeleteMapping("/delete/{id}")
    public String delPlan(
            @PathVariable Long id   //삭제할 데이터의 id
    ) {
        daily_service.delPlan(id);      //daily_service의 delPlan기능 요청
        return "삭제됨";
    }
}

 */