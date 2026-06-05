package com.travel.planner.Rule;

import com.travel.planner.Exception.NotFound_exception;

public class Api_rule {
    public static void StatusCheck(int status) {
        if(status != 200) {
            throw new NotFound_exception("API 연결에 실패 - 상태코드 : "+ status);
        }
    }
    public static void ResponseCheck(String respData) {
        if(respData == null || respData.trim().isEmpty()) {
            throw new NotFound_exception("API 데이터 수신 실패");
        }
    }
}
