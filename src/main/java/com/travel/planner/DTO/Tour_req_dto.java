package com.travel.planner.DTO;

public class Tour_req_dto {
    private Long userId;
    private Long tourId;
    private String tourType;
    private int howMany;
    private String tourName;
    private String startDate;
    private String endDate;

    public Tour_req_dto() {

    }
    //-- 여행정보를 가져올 사용자 id
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    //-- 어느 여행?
    public Long getTourId() {
        return tourId;
    }
    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }
    //-- 어떤 종류의 여행?
    public String getTourType() {
        return tourType;
    }
    public void setTourType(String tourType) {
        this.tourType = tourType;
    }
    //--인원 수
    public int getHowMany() {
        return howMany;
    }
    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }
    //--여행명
    public String getTourName() {
        return tourName;
    }
    public void setTourName(String tourName) {
        this.tourName = tourName;
    }
    //--여행 시작일
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    //--여행 종료일
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
