package com.travel.planner.DTO;
//사용자가 어떤 조건으로 추천받고 싶은가
public class Recomm_req_dto {
    private String province;
    private String city;
    private String theme;

    public Recomm_req_dto() {

    }
    //--지역
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    //--도시
    public String getCity() {
        return city;
    }
    public void setCity() {
        this.city = city;
    }
    //--테마
    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }
}
