package com.travel.planner.Util;
// JSON 문자열을 트리 구조나 객체로 변환해주는 서버 내장 Jackson 라이브러리 import
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class Json_pas_util {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    //JSON 문자열을 자바 객체로 변환하는 객체 (비용이 매우 커서 프로그램에 하나만 생성)

    public static JsonNode extractItems(String jsonString) { //static - 다른 클래스에서 함수 객체 생성없이 인용가능
        try {
            JsonNode root = objectMapper.readTree(jsonString);
            //api에서 가져온 문자열을 트리 구조 (계층구조)로 파싱
            return root.path("response")
                    .path("body")
                    .path("items")
                    .path("item"); //거름막(계층구조)을 거쳐 관광지 배열이 담긴 'item'을 반환

        } catch (Exception e) {
            return objectMapper.createObjectNode(); //파싱도중 에러 or API 요청값 오류로 인해 문제 발생시 빈 JSON 객체 생성 및 반환
        }
    }

    public static List<JsonNode> convertToList(JsonNode itemNode) { //관광지 추천시 랜덤값을 모을 함수
        List<List<JsonNode>> resultList = new ArrayList<>(); //데이터를 담을 빈 자바 리스트
        List<JsonNode> allTours = new ArrayList<>();

        if(itemNode.isArray()) {
            for(JsonNode node : itemNode) { //JsonNode 계층의 item노드의 관광지 배열에서 값 꺼내기
                allTours.add(node); //관광지 값을 꺼내 allTours 리스트에 add
            }
        }
        return allTours; //JSON 파싱 된 관광지 리스트를 반환
    }
}
