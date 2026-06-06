package com.travel.planner.Service;

import com.travel.planner.DTO.Schedule_req_dto;
import com.travel.planner.DTO.Schedule_resp_dto;
import com.travel.planner.Domain.Schedule_domain;
import com.travel.planner.Domain.Tour_domain;
import com.travel.planner.Domain.Place_domain;

import com.travel.planner.Repository.Schedule_repo;
import com.travel.planner.Repository.Tour_repo;
import com.travel.planner.Repository.Place_repo;

import com.travel.planner.Rule.IsNull_rule;
//import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true) //: 읽기전용 - 무분별한 DB수정 방지
public class Schedule_service {
    private final Schedule_repo scheduleRepo;   //repository 객체들
    private final Tour_repo tourRepo;
    private final Place_repo placeRepo;

    public Schedule_service(Schedule_repo scheduleRepo, Tour_repo tourRepo, Place_repo placeRepo) {
        this.scheduleRepo = scheduleRepo;
        this.tourRepo = tourRepo;
        this.placeRepo = placeRepo;
    }
    //일정 생성 요청
    @Transactional
    public Long createSchedule(Schedule_req_dto dto) {
        Tour_domain tour = tourRepo.getReferenceById(dto.getTourId());
        Place_domain place = placeRepo.findById(dto.getPlaceId()).orElse(null);
        IsNull_rule.NullCheck(place, "장소가 존재하지 않습니다.");

        Schedule_domain schedule = new Schedule_domain(); //일정이 있다면 객체 생성
        schedule.setTourId(tour);
        schedule.setPlaceId(place); //존재하는 장소 세팅
        schedule.setVisitDate(dto.getVisitDate());
        schedule.setVisitTime(dto.getVisitTime());

        scheduleRepo.save(schedule);
        return schedule.getScheduleId();
    }
    public List<Schedule_resp_dto> getScheduleByTour(Long tourId) {
        //tourId를 가리키는 일정을 List로 모음
        List<Schedule_domain> schedules = scheduleRepo.findByTourId_TourId(tourId);

        return schedules.stream().map(this::convertToRespDto)
                .collect(Collectors.toList());
    }

    //일정 수정 요청
    @Transactional
    public void updateSchedule(Long scheduleId, Schedule_req_dto dto) {
        Schedule_domain schedule = scheduleRepo.findById(scheduleId).orElse(null);
        IsNull_rule.NullCheck(schedule, "일정이 존재하지 않습니다.");
        Place_domain newPlace = placeRepo.findById(dto.getPlaceId()).orElse(null);
        IsNull_rule.NullCheck(newPlace, "등록된 장소가 없습니다.");

        schedule.setPlaceId(newPlace);
        schedule.setVisitDate(dto.getVisitDate());
        schedule.setVisitTime(dto.getVisitTime());
    }
    //일정 삭제 요청
    @Transactional
    public void deleteSchedule(Long scheduleId) {
        Schedule_domain schedule = scheduleRepo.findById(scheduleId).orElse(null);
        IsNull_rule.NullCheck(schedule, "삭제할 일정이 없습니다.");
        scheduleRepo.delete(schedule);
    }

    private Schedule_resp_dto convertToRespDto(Schedule_domain schedule) {
        Schedule_resp_dto respDto = new Schedule_resp_dto();
        respDto.setScheduleId(schedule.getScheduleId());

        respDto.setTourId(schedule.getTourId().getTourId());
        respDto.setPlaceId(schedule.getPlaceId().getPlaceId());

        respDto.setVisitDate(schedule.getVisitDate());
        respDto.setVisitTime(schedule.getVisitTime());
        return respDto;
    }
}
