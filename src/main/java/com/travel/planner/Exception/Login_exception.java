package com.travel.planner.Exception;

public class Login_exception extends RuntimeException {
    public Login_exception() { //기본 생성자
        super(); //부모 생성자 호출
    }

    public Login_exception(String message) {
        super(message); //부모 예외 클래스에 메시지 전달
    }
}
