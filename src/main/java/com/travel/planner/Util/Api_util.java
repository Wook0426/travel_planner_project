package com.travel.planner.Util;
import java.net.URLEncoder;
import java.net.URLEncoder;     //한글을 url에서 사용하게끔 인코딩 하는 클래스 사용
import java.nio.charset.StandardCharsets;   //한글 깨짐 방지 utf-8사용 선언
public class Api_util {
    private static final String Keyword_url = "https://apis.data.go.kr/B551011/KorService2/searchKeyword2"; //키워드 기반 관광공사 데이터 접근 url
    private static final String Area_based_url = "https://apis.data.go.kr/B551011/KorService2/areaBasedList2"; // 지역 기반 검색
    private static final String My_Servicekey = "b62e3d02829d1bd1e9b4135abc3ae50862ec9b11c440306275713cfde80d75e7"; //내 key

    public static String Tour_url(String keyword) { //url 생성 메서드
        if(keyword == null || keyword.isBlank()) {
            throw new IllegalArgumentException("Keyword NULL"); //url 삽입값 공백 알림
        }

        String encodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8); //한글 url 인코딩

        return Keyword_url
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
        String processedSignguCd = lDongSignguCd;
        if (lDongSignguCd != null && lDongSignguCd.length() == 5) {
            processedSignguCd = lDongSignguCd.substring(2); //index 0 1 2 3 4 중 2부터 인식
            // 한국관광공사 메뉴얼에 따라 프론트에서 보내는 5자리 지역값을 뒤의 3자리로 변경
        }

        String url = Area_based_url
                + "?serviceKey=" + My_Servicekey
                + "&numOfRows=50"     // 랜덤 셔플을 위해 50개 넉넉히 가져옴
                + "&pageNo=1"
                + "&MobileOS=ETC"
                + "&MobileApp=AppTest"
                + "&arrange=C"        // 최신순 정렬 권장
                + "&lDongRegnCd=" + lDongRegnCd //법정동 시도 코드
                + "&lDongSignguCd=" + processedSignguCd //법정동 시군구 코드
                + "&_type=json";

        // 키워드가 있으면 추가 (없으면 지역 전체 검색)
        if (keyword != null && !keyword.isBlank()) {
            url += "&keyword=" + URLEncoder.encode(keyword, StandardCharsets.UTF_8);
        }

        return url;
    }
}
