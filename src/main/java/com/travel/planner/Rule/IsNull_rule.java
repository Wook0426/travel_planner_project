package com.travel.planner.Rule;

import com.travel.planner.Exception.*;

public class IsNull_rule {
    public static void NullCheck(Object data, String errorMessage) {
        if(data == null) { //모든 실질 객체를 받는 Object == null인지 판별
            throw new Login_exception(errorMessage);
        }
    }
}
