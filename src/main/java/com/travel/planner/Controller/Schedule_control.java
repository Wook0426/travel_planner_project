package com.travel.planner.Controller;

import com.travel.planner.Service.Schedule_service;
import com.travel.planner.DTO.Schedule_req_dto;
import com.travel.planner.DTO.Schedule_resp_dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = "*") //접근허용
public class Schedule_control {
    @Autowired
    private Schedule_service schedule_service; //생성자 없이 서버를 통해 객체 선언

    //일정 생성
    @PostMapping("/save")
    public Long create(
            @RequestBody Schedule_req_dto request //req_dto 객체 request 생성
    ) {
        return schedule_service.createSchedule(request); //service에 createSchedule함수의 dto값을 db에 저장요청
    }
    //해당 여행의 일정보기
    @GetMapping("/list/{tourId}")
    public List<Schedule_resp_dto> list(
            @PathVariable Long tourId //주소창의 가변인자 {tourId}를 변수 tourId에 담아달라는 요청
    ) {
        return schedule_service.getScheduleByTour(tourId);
    }
    //일정 변경
    @PutMapping("/update/{scheduleId}")
    public String update(
        @PathVariable Long scheduleId, @RequestBody Schedule_req_dto request //수정해야하는 일정id, 세부내용 객체
    ) {
        schedule_service.updateSchedule(scheduleId, request);
        return "계획이 수정되었습니다.";
    }
    //일정 삭제
    @DeleteMapping("/delete/{scheduleId}")
    public String delete(
            @PathVariable Long scheduleId
    ) {
        schedule_service.deleteSchedule(scheduleId); //service에게 deleteSchedule로직 요청
        return "일정이 삭제됨";
    }
}
