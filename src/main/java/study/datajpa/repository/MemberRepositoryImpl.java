package study.datajpa.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.datajpa.entity.Member;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor//final 1개일때 생성자생략시켜줌
@Repository
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final EntityManager em;


    @Override
    public List<Member> findMemberCustom() {
        return em.createQuery("select m from Member m").getResultList();
    }//사용자 정의 레포지토리 => querydsl에서 많이 사용
}
