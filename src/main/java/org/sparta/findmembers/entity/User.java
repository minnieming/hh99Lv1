package org.sparta.findmembers.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sparta.findmembers.dto.UserResponseDto;
//import org.springframework.data.annotation.Id;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "user")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // (순번) 구분을 하기 위해서 걸어둠. 데이터베이스에는 필수로 필요하다

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, length = 500)
    private String email;

    @Column(name = "pw", nullable = false, length = 100)
    private String pw;

//    @jakarta.persistence.Id
//    private Long id;

    public UserResponseDto toResponseDto() {

        return new UserResponseDto(this.id, this.name, this.email, this.pw);

    }

    public Long getUserid() {
        return this.id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
}





