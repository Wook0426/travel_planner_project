package com.travel.planner.Util;
import java.net.URLEncoder;
import java.net.URLEncoder;     //한글을 url에서 사용하게끔 인코딩 하는 클래스 사용
import java.nio.charset.StandardCharsets;   //한글 깨짐 방지 utf-8사용 선언
public class Api_util {
    private static final String Base_url = "https://apis.data.go.kr/B551011/KorService2/searchKeyword2"; //관광공사 데이터 접근 url
    private static final String My_Servicekey = "b62e3d02829d1bd1e9b4135abc3ae50862ec9b11c440306275713cfde80d75e7"; //내 key

    public static String Tour_url(String keyword) { //url 생성 메서드
        if(keyword == null || keyword.isBlank()) {
            throw new IllegalArgumentException("Keyword NULL"); //url 삽입값 공백 알림
        }

        String encodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8); //한글 url 인코딩

        return Base_url
                + "?serviceKey=" + My_Servicekey //최종적으로 검색어 연결
                + "&numOfRows=10"
                + "&pageNo=1"
                + "&MobileOS=ETC" //기타 운영체제 라는 의미 - 관광API 필수값
                + "&MobileApp=AppTest"
                + "&arrange=A" //정렬방식
                + "&keyword=" + encodedKeyword
                + "&_type=json"; //JSON형식으로 반환해주세요
    }
    public static String Region_Tour_url(String keyword, String lDongRegnCd, String lDongSignguCd) {

        String url = Base_url
                + "?serviceKey=" + My_Servicekey
                + "&numOfRows=50"     // 랜덤 셔플을 위해 50개 넉넉히 가져옴
                + "&pageNo=1"
                + "&MobileOS=ETC"
                + "&MobileApp=AppTest"
                + "&arrange=C"        // 최신순 정렬 권장
                + "&lDongRegnCd=" + lDongRegnCd //법정동 시도 코드
                + "&lDongSignguCd=" + lDongSignguCd //법정동 시군구 코드
                + "&_type=json";

        // 키워드가 있으면 추가 (없으면 지역 전체 검색)
        if (keyword != null && !keyword.isBlank()) {
            url += "&keyword=" + URLEncoder.encode(keyword, StandardCharsets.UTF_8);
        }

        return url;
    }
}
