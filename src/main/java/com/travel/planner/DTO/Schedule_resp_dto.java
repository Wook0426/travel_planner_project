package com.travel.planner.DTO;

public class Schedule_resp_dto {
    private Long scheduleId;
    private Long tourId;       //Long 사용 : null 처리 가능, 더 큰 숫자 저장 가능
    private Long placeId;
    private String visitDate;
    private String visitTime;

    public Schedule_resp_dto() {
        //DB 저장 결과 반환용 생성자
    }
    //--일정 고유번호
    public Long getScheduleId() {
        return scheduleId;
    }
    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }
    //--특정 여행 고유번호
    public Long getTourId() {
        return tourId;
    }
    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }
    //--특정 장소 고유번호
    public Long getPlaceId() {
        return placeId;
    }
    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }
    //--방문날짜
    public String getVisitDate() {
        return visitDate;
    }
    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }
    //--방문시각
    public String getVisitTime() {
        return visitTime;
    }
    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }
}
