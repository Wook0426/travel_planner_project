package com.travel.planner.DTO;
// req = 사용자 입력값
public class Place_req_dto {    //관광지 요청 데이터를 담는 객체
    private Long placeId;
    private String placeName;       //관광지 이름 저장
    private String placeAddress;     //관광지 주소 저장
    private String imageUrl;       //관광지 이미지 저장
    private String placeDescription;    //관광지 설명 저장
    private String placeType;

    public Place_req_dto() {

    }
    //--장소 고유번호
    public Long getPlaceId() {
        return placeId;
    }
    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }
    //--제목
    public String getPlaceName() {  // Place_resp_dto 객체 생성을 가능케 하는 생성자 - JSON이 사용
        return placeName;           //placeName 값을 JSON으로부터 꺼냄
    }
    public void setPlaceName(String placeName) {
        this.placeName = placeName;     //꺼낸 title을 내부 변수 title에 저장
    }
    //--주소
    public String getPlaceAddress() {
        return placeAddress;
    }
    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }
    //--이미지
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    //--관광지 설명
    public String getPlaceDescription() {
        return placeDescription;
    }
    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }
    //--관광지 분류
    public String getPlaceType() {
        return placeType;
    }
    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }
}
