package com.travel.planner.Domain;
import jakarta.persistence.*; //JPA 관련기능으로, @entity, @table, @id 어노테이션 사용
import java.util.ArrayList;
import java.util.List;

@Entity //이 클래스가 db테이블 자체이다.
@Table(name = "Tour") //그 중에서 tour테이블이다.
public class Tour_domain {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment 설명
    @Column(name = "tourId") //db 칼럼명을 지정
    private Long tourId; //여행 고유번호

    @ManyToOne(fetch = FetchType.LAZY)
    //여러 Tour가 하나의 User를 참조하기 때문에 Tour조회 시 User를 즉시 가져오지 않아 성능향상됨
    @JoinColumn(name = "userId") //userId로 User테이블 연결(tour 테이블과)
    private User_domain userId; //사용자 (user_domain 객체)

    @OneToMany(mappedBy = "tourId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Place_domain> placeId = new ArrayList<>();
    /*
    mappedBy = "tour" : 자신이 tour테이블의 객체임을 알려줌 - 참조를 통해 읽기만 한다.
    cascade = CascadeType.ALL : 부모의 형태변화를 자식에게 동일적용 - tour의 저장,수정,삭제를 place에게 똑같이 적용
    orphanRemoval = true : 리스트에서 장소를 제거했을 때 작동하는 소멸자
    new ArrayList<>() : 리스트 초기화 - NullPointerException 방지
     */

    @Column(name = "tourType")
    private String tourType; //여행 타입 칼럼명

    @Column(name = "howMany")
    private Integer howMany;

    @Column(name = "tourName")
    private String tourName;

    public Tour_domain() {
        //JPA는 기본 생성자를 반드시 요구함
    }

    public Long getTourId() {
        return tourId;  // 여행번호 반환
    }
    public void setTourId(Long tourId) {
        this.tourId = tourId; // 여행번호 저장
    }

    public User_domain getUserId() {
        return userId; //user 테이블 접근 가능 , 작성자(User) 반환
    }
    public void setUserId(User_domain userId) {
        this.userId = userId; //작성자(User) 저장
    }

    public List<Place_domain> getPlaceId() {
        return placeId;
    }
    public void setPlaceId(List<Place_domain> placeId) {
        this.placeId = placeId;
    }

    public String getTourType() {
        return tourType;
    }
    // 여행 타입 반환
    public void setTourType(String tourType) {
        this.tourType = tourType;
    }
    // 여행 타입 저장

    public Integer getHowMany() {
        return howMany;
    }
    // 여행 인원수 반환
    public void setHowMany(Integer howMany) {
        this.howMany = howMany;
    }
    // 여행 인원수 저장

    public String getTourName() {
        return tourName;
    }
    // 여행 이름 반환
    public void setTourName(String tourName) {
        this.tourName = tourName;
    }
    // 여행 이름 저장
}
