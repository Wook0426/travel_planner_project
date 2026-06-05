package com.travel.planner.Repository;
import com.travel.planner.Domain.Schedule_domain;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Schedule_repo extends JpaRepository<Schedule_domain, Long>{
    //Schedule_domain의 db 접근을 관리하고, 해당 테이블의 primary key는 Long타입이다.
    List<Schedule_domain> findByTourId_TourId(Long tourId);
    //Schedule_domain 내부 tourId와 일치하는 schedule만 가져온다.
}
