package com.travel.planner.Domain;
import jakarta.persistence.*; //JPA 관련기능으로, @entity, @table, @id 어노테이션 사용

import java.util.ArrayList;
import java.util.List;

@Entity //이 클래스가 db테이블 자체이다.
@Table(name = "Place") //그 중에서 Place테이블이다.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //상속 구조 사용 - 부모/자식 분리
@DiscriminatorColumn(name = "placeType") //타입으로 분리
public abstract class Place_domain { //직접 객체 생성 불가능한 클래스
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment 설명
    @Column(name = "placeId") //db 칼럼명을 지정
    private Long placeId; //관광지 고유번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tourId")
    private Tour_domain tourId; //tour 테이블 many-to-one연결 객체

    @OneToMany(mappedBy = "placeId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review_domain> reviewId = new ArrayList<>();

    @Column(name = "placeName", nullable = false)
    private String placeName; //관광지명 칼럼명

    @Column(name = "placeAddress")
    private String placeAddress;

    @Column(name = "placeDescription", columnDefinition = "TEXT") //긴 문자열 저장 가능
    private String placeDescription;

    @Column(name = "imageUrl")
    private String imageUrl;
/*
    @Column(name = "place_type", insertable = false, updatable = false) //JPA가 자동으로 값을 넣고 관리할 테니, 자바 변수 쪽에서는 읽기 전용으로 만들어라
    private String placeType;
*/
    public Place_domain() {
        //기본 생성자
    }

    public Long getPlaceId() {
        return placeId;
    }
    public void setPlaceId(Long placeId) { //칼럼1 : place_id
        this.placeId = placeId;
    }

    public Tour_domain getTourId() {
        return tourId;
    }
    public void setTourId(Tour_domain tourId) {
        this.tourId = tourId;
    }

    public List<Review_domain> getReviewId() {
        return reviewId;
    }
    public void setReviewId(List<Review_domain> reviewId) {
        this.reviewId = reviewId;
    }

    public String getPlaceName() {
        return placeName;
    }
    public void setPlaceName(String placeName) { //칼럼2 : place_name
        this.placeName = placeName;
    }

    public String getPlaceAddress() {   //칼럼3 : place_address
        return placeAddress;
    }
    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }
/*
    public String getPlaceType() {
        return placeType;
    }
    public void setPlaceType(String placeType) { //칼럼4 : place_type
        this.placeType = placeType;
    }
*/
    public String getDescription() {
        return placeDescription;
    }
    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
