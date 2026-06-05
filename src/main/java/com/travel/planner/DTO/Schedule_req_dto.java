package com.travel.planner.DTO;

public class Schedule_req_dto {
    private Long scheduleId;
    private Long tourId;
    private Long placeId;
    private String visitDate;
    private String visitTime;

    public Schedule_req_dto() {

    }
    //--여행 일정 고유번호
    public Long getScheduleId() {
        return scheduleId;
    }
    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }
    //--어느 여행
    public Long getTourId() {
        return tourId;
    }
    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }
    //--어떤 장소
    public Long getPlaceId() {
        return placeId;
    }
    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }
    //--언제
    public String getVisitDate() {
        return visitDate;
    }
    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }
    //--방문시간
    public String getVisitTime() {
        return visitTime;
    }
    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }
}