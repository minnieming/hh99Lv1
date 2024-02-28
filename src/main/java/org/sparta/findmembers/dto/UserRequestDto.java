package org.sparta.findmembers.dto;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserRequestDto {
    private Long userId; // (순번) 구분을 하기 위해서 걸어둠. 데이터베이스에는 필수로 필요하다
    private String name;
    private String email;
    private String pw;
}
