package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.entity.Team;
//@repository생략가능(컴포넌트스캔알아서해줌)
public interface TeamRepository extends JpaRepository<Team,Long> {

}
