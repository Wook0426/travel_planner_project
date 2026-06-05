package com.travel.planner.DTO;

public class Recomm_resp_dto {
    private Long placeId;
    private String placeName;
    private String placeAddress;
    private String placeType;
    private String image;

    public Recomm_resp_dto() {

    }
    //--이곳을 추천하겠다
    public Long getPlaceId() {
        return placeId;
    }
    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }
    //--관광지의 이름은
    public String getPlaceName() {
        return placeName;
    }
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
    //--관광지의 주소는
    public String getPlaceAddress() {
        return placeAddress;
    }
    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }
    //--이러한 관광지이다
    public String getPlaceType() {
        return placeType;
    }
    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }
    //--이렇게 생겼다
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}