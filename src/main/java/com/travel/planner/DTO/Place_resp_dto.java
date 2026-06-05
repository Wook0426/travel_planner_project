package com.travel.planner.DTO;
/*
dto는 보통 변수, getter/setter, 생성자 정도만 가진 로직이 거의 없는 클래스
 */
// resp = DB 저장 후 결과
public class Place_resp_dto {   //관광지 응답 데이터를 저장할 클래스
    private Long placeId;       //관광지 이름 저장
    private String placeAddress;     //관광지 주소 저장
    private String imageUrl;       //관광지 이미지 저장
    private String placeDescription;    //관광지 설명 저장
    private String placeName;
    private String placeType;

    public Place_resp_dto() {

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
        this.placeName = placeName;     //꺼낸 placeName을 내부 변수 title에 저장
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
