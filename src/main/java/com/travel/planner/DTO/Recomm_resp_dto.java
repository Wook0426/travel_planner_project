package com.travel.planner.DTO;

public class Recomm_resp_dto {
    private String province;
    private String city;
    private String theme;

    public Recomm_resp_dto() {

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
    public void setCity(String city) {
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