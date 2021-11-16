package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id","username","age"})
@NamedQuery(
        name = "Member.FindByUsername",
        query = "select m from Member m where m.username = :username"
)
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    //jpa는 기본생성자필요함, 프록시,등에 필요한 기능을위해 private까지 닫으면 안됨
    public Member(String username) {
        this.username = username;
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if(team!=null){
            changeTeam(team);
        }
//null이면 무시
    }

    public void changeTeam(Team team){
        this.team= team;
        team.getMembers().add(this);
    }
}
