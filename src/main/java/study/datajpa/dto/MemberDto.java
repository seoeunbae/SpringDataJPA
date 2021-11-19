package study.datajpa.dto;

import study.datajpa.entity.Member;

public class MemberDto {
    private Long id;
    private String username;
    private String teamName;

    public MemberDto(Long id, String username){
        this.id = id;
        this.username = username;
    }
}
