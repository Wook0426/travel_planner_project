package com.travel.planner.Rule;
import com.travel.planner.Exception.*;
public class Login_rule {
    public static void PasswordCheck(String inputPassword, String rightPassowrd) {
        if(!inputPassword.equals(rightPassowrd)) {
            throw new NotFound_exception("비밀번호가 일치하지않음");
        }
    }
    public static void LengthCheck(String id, String password) {
        if(id.length() < 4 || password.length() < 8) {
            throw new NotFound_exception("아이디는 4자 이상, 비밀번호는 8자 이상이어야 합니다.");
        }
    }
}
