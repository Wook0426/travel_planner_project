package com.travel.planner.Domain;
import jakarta.persistence.*; //JPA 관련기능으로, @entity, @table, @id 어노테이션 사용

@Entity //이 클래스가 db테이블 자체이다.
@Table(name = "Schedule") //그 중에서 Schedule테이블이다.
public class Schedule_domain {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment 설명
    @Column(name = "scheduleId")
    private Long scheduleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tourId") //tour_id로 tour테이블과 연결(schedule 테이블과)
    private Tour_domain tourId; //어느 여행

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "placeId") // schedule은 tour와 place 둘 모두와 틀을 공유하므로 join연결한다.
    private Place_domain placeId;

    @Column
    private String placeName;

    @Column(name = "visitDate") //날짜 칼럼
    private String visitDate;

    @Column(name = "visitTime") //방문시간 칼럼
    private String visitTime;

    public Schedule_domain() {
        //JPA는 기본 생성자를 반드시 요구함
    }
    public Tour_domain getTourId() {
        return tourId;
    }
    public void setTourId(Tour_domain tourId) {
        this.tourId = tourId;
    }
    public Place_domain getPlaceId() {
        return placeId;
    }
    public void setPlaceId(Place_domain placeId) {
        this.placeId = placeId;
    }
    public Long getScheduleId() {
        return scheduleId;
    }
    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getVisitDate() { //날짜 반환
        return visitDate;
    }
    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }
    public String getVisitTime() { //방문 시간 반환
        return visitTime;
    }
    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }
    public String getPlaceName() {
        return placeName;
    }
    public void setPlaceName(String placeName) {
        // 만약 Place 객체(placeId)가 비어있지 않다면, 거기서 실시간으로 이름을 가져와 저장할 수도 있습니다.
        if (this.placeId != null && placeName == null) {
            this.placeName = this.placeId.getPlaceName();
        } else {
            this.placeName = placeName;
        }
    }
}
