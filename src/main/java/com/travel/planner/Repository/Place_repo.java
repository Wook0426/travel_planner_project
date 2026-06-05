package com.travel.planner.Repository;
import com.travel.planner.Domain.Place_domain;
import org.springframework.data.jpa.repository.JpaRepository;
public interface Place_repo extends JpaRepository<Place_domain, Long> {
    //Place_domain의 db접근 관리, primary key의 타입은 Long

}
