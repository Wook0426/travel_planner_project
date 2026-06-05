package com.travel.planner.Repository;
import com.travel.planner.Domain.Tour_domain;
import org.springframework.data.jpa.repository.JpaRepository; //JPA 기본 repository기능 사용 - RUD 기능 자동제공
import java.util.List; //여러 개 데이터 반환
import java.util.Optional; //null 안전 처리 객체

public interface Tour_repo extends JpaRepository<Tour_domain, Long> { //서버가 자동으로 구현제를 생성하기 때문에 interface 사용
    //= 이 repository는 Tour_domain entity를 관리한다.
    Optional<Tour_domain> findByTourIdAndUserId_userId(Long tourId, Long userId); //사용자1의 여행1 조회

    List<Tour_domain>
    findByUserId_userId(Long userId); //특정 사용자의 여행 전체 조회

    List<Tour_domain>
    findByTourName(String tourName); //여행 이름으로 조회

    long countByUserId_userId(Long userId); //사용자1의 여행 개수 조회

    boolean existsByTourIdAndUserId_userId(Long tourId, Long userId); //사용자1의 여행1이 존재하는가?

    void deleteByUserId_userId(Long userId); //사용자1의 여행 전체 삭제
}
