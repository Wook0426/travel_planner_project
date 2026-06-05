package com.travel.planner.Domain;
import jakarta.persistence.*; //JPA 관련기능으로, @entity, @table, @id 어노테이션 사용

import java.util.ArrayList;
import java.util.List;

@Entity //db테이블과 연결되는 클래스
@Table(name = "Users") //
public class User_domain {
    @Id //primary key 설명
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment 설명
    @Column(name = "userId") //userid를 통해 User테이블 연결 - foreign key 설명
    private Long userId;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tour_domain> tourId = new ArrayList<>();
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review_domain> reviewId = new ArrayList<>();

    @Column(name = "loginId", nullable = false, unique = true)
    //로그인 아이디는 null과 중복을 불허함
    private String loginId;

    @Column(nullable = false)
    private String loginPassword; //비밀번호는 null일 수 없음

    @Column(nullable = false)
    private String userName; //사용자 이름은 null일 수 없음

    @Column(nullable = false, unique = true)
    private String userEmail; //이메일은 중복 금지

    public User_domain() {
        //JPA는 기본 생성자를 반드시 요구함
    }

    public Long getUserId() {
        return userId; // userId 반환
    }
    public void setUserId(Long userId) {
        this.userId = userId; // userId 저장
    }

    public List<Review_domain> getReviewId() {
        return reviewId;
    }
    public void setReviewId(List<Review_domain> reviewId) {
        this.reviewId = reviewId;
    }

    public List<Tour_domain> getTourId() {
        return tourId;
    }
    public void setTourId(List<Tour_domain> tourId) {
        this.tourId = tourId;
    }

    public String getLoginId() {
        return loginId; // loginId 반환
    }
    public void setLoginId(String loginId) {
        this.loginId = loginId; // loginId 저장
    }

    public String getLoginPassword() {
        return loginPassword; // password 반환
    }
    public void setLoginPassword(String password) {
        this.loginPassword = loginPassword; // password 저장
    }

    public String getUserName() {
        return userName; // 사용자 이름 반환
    }
    public void setUserName(String UserName) {
        this.userName = userName; // 사용자 이름 저장
    }

    public String getUserEmail() {
        return userEmail; // 이메일 반환
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail; // 이메일 저장
    }
}
