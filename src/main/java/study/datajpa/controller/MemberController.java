package study.datajpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.datajpa.dto.MemberDto;
import study.datajpa.entity.Member;
import study.datajpa.repository.MemberRepository;

import javax.annotation.PostConstruct;
import java.awt.print.Pageable;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping("/members/{id}")
    public String findMember(@PathVariable("id") Member member) {
        return member.getUsername();
    }

    @GetMapping("/members")//"ex.URL=/members.?page=0&size=id,desc&sort=username,desc"이런식으로 추가할수있다. size default=20개
    public Page<Member> list(@PageableDefault(size=5) Pageable pageable){
        Page<Member> page= memberRepository.findAll(pageable);
        return page.<MemberDto>map(member -> new MemberDto(member.getId(), member.getUsername()));
    }
    @PostConstruct
    public void init() {
        for(int i=0;i<100;i++){
            memberRepository.save(new Member("user"+i,i));
        }
    }
}
