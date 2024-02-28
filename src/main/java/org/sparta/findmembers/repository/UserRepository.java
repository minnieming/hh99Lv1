package org.sparta.findmembers.repository;

import org.sparta.findmembers.dto.UserResponseDto;
import org.sparta.findmembers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserById(Long userId);


//    private final JdbcTemplate jdbcTemplate;
//
//    public UserRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public UserResponseDto findUserById(Long userId) {
//
//        String sql = "SELECT * FROM user WHERE userId = ?";
//
//        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new RowMapper<UserResponseDto>() {
//            @Override
//            public UserResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Long userId = rs.getLong("userId");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String pw = rs.getString("pw");
//                return new UserResponseDto(userId, name, email, pw);
//            }
//        });
//    }
//
//    public List<UserResponseDto> findAll() {
//
//        String sql = "SELECT * FROM user"; // 1. select문. string값으로 만들어 놓은 것 // ORDER BY date DESC를 통해 작성일 기준으로 내림차순 정렬 한다.
//
//        return jdbcTemplate.query(sql, new RowMapper<UserResponseDto>() { // 2. select문은 query를 사용한다. (sql은 string으로 만들어 놓은것을 넣은 것 / 뒤에 있는건 밑에 있는 값인듯)
//            @Override
//            public UserResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException { // 3. 여기 데이터가 for문처럼 돌아서 ResultSet에 담긴다
//                // SQL 의 결과로 받아온 Memo 데이터들을 MemoResponseDto 타입으로 변환해줄 메서드
//                Long userId = rs.getLong("userId"); // 4. get으로 가져올수 있다. get뒤에 타입을 적어서 가져오면 된다. (해당하는 column의 이름)
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String pw = rs.getString("pw");
//                return new UserResponseDto (userId, name, email, pw); // 5. 값을 가져오면 MemoResponseDto로 하나로 만들어 지는 것. 이걸로 돌면서 MemoResponseDto의 객체가 만들어진다
//            }
//        });
//
//    }
}
