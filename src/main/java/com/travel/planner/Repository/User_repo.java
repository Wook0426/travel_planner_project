package com.travel.planner.Repository;
import com.travel.planner.Domain.User_domain;
import org.springframework.data.jpa.repository.JpaRepository; //JPA 기본 repository기능 사용 - RUD 기능 자동제공
import java.util.Optional; //예외발생 처리를 잘하는 객체 상자

public interface User_repo extends JpaRepository<User_domain, Long> {
    Optional<User_domain> findByLoginId(String loginId); //loginId로 사용자 찾기 - 아이디 중복체크

    boolean existsByUserEmail(String userEmail); //userEmail로 이메일 중복 체크
}
