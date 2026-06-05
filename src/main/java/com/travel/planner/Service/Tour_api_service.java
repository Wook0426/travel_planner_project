package com.travel.planner.Service;

import com.travel.planner.Exception.Api_exception;
import com.travel.planner.Util.Api_util;        //api url호출 역할을 util에게 위임
import com.travel.planner.Util.Json_pas_util; //Json 파싱 담당 클래스 import

import com.fasterxml.jackson.databind.JsonNode; //파싱된 JSON 객체를 다루는 타입
import org.springframework.stereotype.Service;  //서버에게 이 클래스가 service계층임을 알려주는 어노테이션
import org.springframework.web.client.RestTemplate; //외부 api호출에 get요청을 보내는데 사용
import java.net.URLEncoder;     //한글을 url에서 사용하게끔 인코딩 하는 클래스 사용
import java.nio.charset.StandardCharsets;   //한글 깨짐 방지 utf-8사용 선언
import java.util.Collections;
import java.util.List;

@Service    //Spring bean 등록 - 서버 실행시 자동으로 객체 생성 - controller에서 자동 주입 가능
public class Tour_api_service { //관광공사 서버 접속
    private final RestTemplate restTemplate;    //외부 api호출 객체 - 인터넷 연결기능 (scanner 마냥 고유기능)

    public Tour_api_service() { //객체 생성 시 자동실행
        this.restTemplate = new RestTemplate(); //restTemplate 객체의 생성자
        //restTemplate : spring에서 제공하는 인터넷 요청 기능 - 관광 api와 연결
    }

    public List<JsonNode> callTourApi(String keyword) { //검색어 keyword에 대한 파싱 관광지 리스트를 반환하는 함수
        if(keyword == null || keyword.isBlank()) {
            throw new Api_exception("검색어가 없습니다.");
        }
        //keyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8);   //인코딩
        String api_url = Api_util.Tour_url(keyword); //인코딩 된 문자열을 util에 전송
        String response_body = restTemplate.getForObject(api_url, String.class); //get방식으로 api을답 결과를 string으로 반환받음
        if(response_body == null || response_body.isBlank()) {
            throw new Api_exception ("Tour api 응답이 없습니다.");
        }
        JsonNode itemNode = Json_pas_util.extractItems(response_body); //api응답 중 관광지 item만 추출하여 리스트 반환
        return Json_pas_util.convertToList(itemNode);
    }

    public List<JsonNode> getRecommendTours(String keyword, String lDongRegnCd, String lDongSignguCd) {
        String apiUrl = Api_util.Region_Tour_url(keyword, lDongRegnCd, lDongSignguCd); //실제 외부 api 통신 객체
        //법정동 코드를 받아 url생성
        String responseJson = restTemplate.getForObject(apiUrl, String.class);
        //생성된 url로 외부 api요청
        if(responseJson == null || responseJson.isBlank()) {
            throw new Api_exception("해당 지역의 관광지 정보를 불러오지 못했습니다.");
        }

        JsonNode itemsNode = Json_pas_util.extractItems(responseJson);
        //파싱된 계층의 관광지 부분 item = responseJson 추출
        List<JsonNode> tourList = Json_pas_util.convertToList(itemsNode);
        //추출한 JSON 노드를 List로 변환
        if(tourList == null || tourList.isEmpty()) {
            return tourList;
        }
        Collections.shuffle(tourList); //관광지 리스트를 섞음
        return tourList.subList(0, Math.min(55, tourList.size()));
        //그 중 5개만 최종 반환
    }
}
