package study.datajpa.repository;

import org.springframework.stereotype.Repository;
import study.datajpa.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberJpaRepository {

    @PersistenceContext //스프링 컨테이너가 entityManager를 가져다준다.
    private EntityManager em;

    public Member save(Member member){
        em.persist(member);
        return member;
    }

    public void delete(Member member){
        em.remove(member);
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }

    public Optional<Member> findById(Long id){
        Member member = em.find(Member.class , id);
        return Optional.ofNullable(member);
    }

    public long count(){
        return em.createQuery("select count(m) from Member m",Long.class).getSingleResult();
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

//    public List<Member> findByUsername(String username){
//        return em.createQuery("Member.findByUsername", Member.class).setParameter("username","회원1").getResultList();
//    }
    
}
