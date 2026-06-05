package com.travel.planner.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //화면에 404 Not Found 에러 자동 출력
public class NotFound_exception extends RuntimeException {
    public NotFound_exception(String message) {
        super(message);
    }
}
