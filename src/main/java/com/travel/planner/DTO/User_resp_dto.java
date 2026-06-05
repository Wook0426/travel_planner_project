package com.travel.planner.DTO;

public class User_resp_dto {
    private Long userId;
    private String loginId;
    //private String loginPassword;
    private String userName;
    private String userEmail;

    public User_resp_dto() {

    }
    //--사용자 고유 id
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
    //--사용자 이름
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    //--사용자 인증 메일
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
