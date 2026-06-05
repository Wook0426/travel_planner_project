package com.travel.planner.Domain;
import jakarta.persistence.*;

@Entity //이것은 테이블이다
@Table(name = "Review") //그 중에서도 Review 테이블이다.
public class Review_domain {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment 설명
    @Column(name = "reviewId")
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY) //fetch : db에 연관된 객체를 Lazy(필요할 때)가져오기
    @JoinColumn(name = "userId") // user join review
    private User_domain userId; //어느 여행

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "placeId") //place join review
    private Place_domain placeId;

    @Column(name = "Rating") //점수
    private Integer Rating;
    @Column(name = "Content") //리뷰내용
    private String Content;

    public Review_domain() {
        //JPA가 요구하는 기본 생성자
    }
    public Long getReviewId() {
        return reviewId;
    }
    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }
    public User_domain getUserId() {
        return userId;
    }
    public void setUserId (User_domain userId) {
        this.userId = userId;
    }
    public Place_domain getPlaceId() {
        return placeId;
    }
    public void setPlaceId (Place_domain placeId) {
        this.placeId = placeId;
    }

    public Integer getRating() {
        return Rating;
    }
    public void setRating(Integer Rating) {
        this.Rating = Rating;
    }

    public String getContent() {
        return Content;
    }
    public void setContent(String Content) {
        this.Content = Content;
    }
}
