package com.travel.planner.DTO;

public class User_req_dto {
    private Long userId;
    private String loginId;
    private String loginPassword;    //user_resp에는 비밀번호 x - 보안문제
    private String userName;
    private String userEmail;

    public User_req_dto() {

    }
    //--사용자 고유번호
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    //--사용자 아이디
    public String getLoginId() {
        return loginId;
    }
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    //--사용자 비밀번호
    public String getLoginPassword() {
        return loginPassword;
    }
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
    //--사용자 이름
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    //--사용자 인증메일
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
