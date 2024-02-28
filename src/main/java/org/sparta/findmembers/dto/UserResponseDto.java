package org.sparta.findmembers.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sparta.findmembers.entity.User;

@Getter
@NoArgsConstructor
public class UserResponseDto {

    private Long userId;
    private String name;
    private String email;
    private String pw;

    public UserResponseDto(Long userId, String name, String email, String pw) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.pw = pw;
    }


    public UserResponseDto(User user) {
        this.userId = user.getUserid();
        this.name = user.getName();
        this.email = user.getEmail();
        this.pw = user.getPw();
    }
}