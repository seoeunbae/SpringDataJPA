package study.datajpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import study.datajpa.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long>, MemberRepositoryCustom {
    Page<Member> findByAge(int age, Pageable pageable);
    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") List<String> names);
    @Modifying//update할때는 꼭 넣어줘야한다. select실행할수도있음
    @Query("update Member m set m.age = m.age + 1 where m.age >=:age")
    int bulkAgePlus(@Param("age") int age);
    List<Member> findByUsername(String username);
    @Override
    @EntityGraph(attributePaths = {"team"})//team까지 조회하고 싶을때! (내부적으로는 fetchjoin이 사용된다.)
    List<Member> findAll();

    @EntityGraph(attributePaths = {"team"})
    List<Member> findEntityGraphByUsername(@Param("username") String username);
}
