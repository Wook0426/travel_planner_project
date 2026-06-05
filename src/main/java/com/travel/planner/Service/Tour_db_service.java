package com.travel.planner.Service;

import com.travel.planner.Domain.Tour_domain; //실질 여행정보 객체 - db 테이블과 연결
import com.travel.planner.Exception.NotFound_exception; //db 여행정보 접근시 예외처리
import com.travel.planner.Repository.Tour_repo; //db 실행 담당

import org.springframework.beans.factory.annotation.Autowired; //spring에게 @객체 자동 연결 요청 (spring이 관리하는 객체 : bean)
import org.springframework.stereotype.Service; //서버에 service 로직을 수행함을 등록
import java.util.List; //여러 데이터 저장을 위한 java list
import java.util.Optional; //null 값으로부터 안전한 객체

@Service
public class Tour_db_service {
    private final Tour_repo tour_repo;  //repostiory 객체

    @Autowired //서버가 repository 자동 연결
    public Tour_db_service(Tour_repo tour_repo) {   //repository 객체의 생성자
        this.tour_repo = tour_repo;
    }
    //--생성
    public Tour_domain saveTour(Tour_domain domain) { //관광 데이터 생성 메서드 (create)
        if(domain == null) {
            throw new IllegalArgumentException("Tour Domain NULL");   //실질적 객체가 없다면 반환
        }
        if(domain.getTourName() == null || domain.getTourName().isBlank()) { //관광지 이름이 존재하는가?
            throw new IllegalArgumentException("Tour Name NULL");
        }
        if(domain.getUserId() == null) {
            throw new IllegalArgumentException("User ID NULL");
        }
        return tour_repo.save(domain); //객체로 가져온 데이터 domain을 repository에 저장
    }
    //--전체 조회
    public List<Tour_domain> findAllTour() { //list를 활용하여 전체 관광데이터 조회
        List<Tour_domain> tour_list = tour_repo.findAll(); //repository에서 실질적 여행객체 리스트 꺼내기

        if(tour_list.isEmpty()) {
            throw new NotFound_exception("Tour List Empty"); //찾는 여행이 없다면 공값 처리
        }
        return tour_list;
    }
    //--단일 조회
    public Tour_domain findTourById(Long userId, Long tourId) {
        if(userId == null) {    //사용자 id 검증
            throw new IllegalArgumentException("User ID NULL");
        }
        if(tourId == null) {    //여행 id 검증
            throw new IllegalArgumentException("Tour ID NULL");
        }
        Optional<Tour_domain> optional = tour_repo.findByTourIdAndUserId_userId(tourId, userId);
        if(optional.isEmpty()) {
            throw new NotFound_exception("Tour Not Found");
        }
        return optional.get();
    }
    //--수정
    public Tour_domain updateTour(Long userId, Long tourId, Tour_domain update_domain) {
        //현재 데이터 조회
        Tour_domain find_domain = findTourById(userId, tourId);

        find_domain.setTourName(update_domain.getTourName()); //여행명 수정
        find_domain.setTourType(update_domain.getTourType()); //여행 종류 수정
        find_domain.setHowMany(update_domain.getHowMany()); //인원 수 수정
        return tour_repo.save(find_domain); //수정한 값 저장
    }
    //--삭제
    public void deleteTour(Long userId, Long tourId) {
        Tour_domain find_domain = findTourById(userId, tourId); //삭제할 값 find
        tour_repo.delete(find_domain); //삭제 로직 실행
    }
}
