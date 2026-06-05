/*package com.travel.planner.Controller;

import com.travel.planner.DTO.Weather_resp_dto; //dto를 통한 화면 출력용 정보 추출
import com.travel.planner.Service.Weather_service;  //service 패키지에 api호출 작업 요청
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController                                 //사용자 요청을 처리하는 controller 선언 - 반환값을 자동으로 JSON 변환
@CrossOrigin(origins = "*")                     //HTML(js)에서 spring 서버 접근 허용 ... 사실 '*'로 모든 주소 허용 (origin = 주소 + 포트) - Cross-Origin Resource Sharing 오류발생방지
@RequestMapping("/weather")                        //공통 url 연결 요청 ("/tour" + /search or /list or ...)
public class Weather_control {
    @Autowired
    private Weather_service weather_service;

    @GetMapping("/weather")     //브라우저 요청대기 8080/weather
    public Weather_resp_dto weather(
            @RequestParam String city   //사용자 입력
    ) {
        return wheather_service.weather(city);  //json파싱결과 반환
    }
}

 */