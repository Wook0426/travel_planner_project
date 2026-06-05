package com.travel.planner.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class Api_exception extends RuntimeException { //실행 중 발생하는 예외 클래스 RuntimeException 클래스 상속
    //RuntimeException = java내장 클래스로써, 따로 구현 x
    public Api_exception() { //기본 생성자
        super(); //부모 생성자 호출
    }

    public Api_exception(String message) {
        super(message); //부모 예외 클래스에 메시지 전달
    }

    public Api_exception(String message, Throwable cause) { //Throwable = 모든 오류의 부모타입 으로써, cause는 실제 원인 오류 객체이다.
        super(message, cause); //메시지 내용과 증상 전달
    }
}
