package com.travel.planner.Service;
import com.travel.planner.Domain.User_domain;
import com.travel.planner.DTO.User_req_dto;
import com.travel.planner.DTO.User_resp_dto;
import com.travel.planner.Repository.User_repo;
import com.travel.planner.Rule.IsNull_rule;
import com.travel.planner.Rule.Login_rule;
import org.springframework.stereotype.Service; //@service, @repository, @controller등 어떤 역할인지 명시하는 어노테이션
import org.springframework.transaction.annotation.Transactional; //transactional - 메서드 내부 코드가 완성되어야만 db에 반영하는 장치 (중간중단시 데이터 중복방지)
//import java.util.Optional;

@Service
@Transactional(readOnly = true) //조회 메서드 성능 최적화
public class User_service {
    private final User_repo userRepo;
    public User_service(User_repo userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional //db에 저장해야하므로 readOnly 무시 - 쓰기 권한 부여 단, 모두 작성시에만
    public Long Check(User_req_dto dto) {
        IstwoLoginId(dto.getLoginId()); //아이디 중복검사
        IstwoEmail(dto.getUserEmail()); //이메일 중복?

        User_domain user = new User_domain(); //중복 검사 통과시 domain호출
        user.setLoginId(dto.getLoginId()); //각 정보 기입
        user.setLoginPassword(dto.getLoginPassword());
        user.setUserName(dto.getUserName());
        user.setUserEmail(dto.getUserEmail());

        userRepo.save(user); //진짜 DB 저장
        return user.getUserId(); //저장 종료 후 user의 고유번호 반환 - 이 사용자는 무결하다
    }
    //domain의 userId와 user_repo의 findByLoginId 함수의 결과값이 일치하는가?
    public User_resp_dto loginVerify(String loginId, String loginPassword) {
        User_domain userId = userRepo.findByLoginId(loginId).orElse(null);
        IsNull_rule.NullCheck(userId, "아이디가 존재하지 않습니다.");
        Login_rule.PasswordCheck(loginPassword, userId.getLoginPassword());
        /*
        if(!userId.getLoginPassword().equals(loginPassword)) { //domain의 getLoginPassword함수 반환값이 loginPassword와 일치하지 않으면
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        */
        return convertToRespdto(userId); //dto변환 함수 호출
    }

    private void IstwoLoginId (String loginId) {
        userRepo.findByLoginId(loginId) //user_repo의 findByLoginId함수 반환값이
                .ifPresent(m -> { //domain에 존재한다면
                    throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
                });
    }
    private void IstwoEmail (String userEmail) {
        if(userRepo.existsByUserEmail(userEmail)) { //user_repo 클래스의 existsByUserEmail함수의 boolean값이 true라면
            throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
        }
    }
    private User_resp_dto convertToRespdto(User_domain userId) {
        User_resp_dto respDto = new User_resp_dto(); //dto반환 객체
        respDto.setUserId(userId.getUserId());
        respDto.setLoginId(userId.getLoginId());
        respDto.setUserName(userId.getUserName());
        respDto.setUserEmail(userId.getUserEmail());
        return respDto; //검증마친 고유번호 + 아이디 + 이름 + 이메일
    }
}
