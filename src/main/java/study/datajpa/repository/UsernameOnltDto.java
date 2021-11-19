package study.datajpa.repository;

public class UsernameOnltDto {
    public UsernameOnltDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    private final String username;

}
