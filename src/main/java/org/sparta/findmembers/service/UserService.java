package org.sparta.findmembers.service;

import lombok.RequiredArgsConstructor;
import org.sparta.findmembers.dto.UserResponseDto;
import org.sparta.findmembers.entity.User;
import org.sparta.findmembers.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository; // DB에 접근하여 데이터를 가져올수 있게 해주는 객체.

    public UserResponseDto findUser(Long userId) { // 모든 클래스에서 접근 가능한 finduser라는 이름을 가진 메서드. 반환값은 userresponsedto 클래스이며 파라미터로 long타입의 인자를 받는다.
        User user = userRepository.findUserById(userId); // userrepository 객체에 접근해서 finduserbyid라는 메서드를 실행시키는데 해당하는 메서드는 파라매터로 받아온 long타입의 변수를 이용해서 User객체를 찾아오는 기능을 한다. 그 객체를 user라는 변수에 저장한다.
        UserResponseDto response = user.toResponseDto(); // user객체의 toresponsedto라는 메서드를 이용해서 userresponsedto의 객체를 생성해서 response라는 변수에 넣었다.
        return response; // response를 반환한다.
    }

    // userrepository에서 존재하는 모든 user레코드를 찾아서 각각의 user레코드를 userresponsedto라는 객체로 변환 후 비어있는 리스트에 넣고 그 객체를 반환한다.
//    public List<UserResponseDto> findAllUser() { // 모든 클래스에 접근 가능한 findalluser 메서드. 반환값은 userresponseDto에 List 형식으로 반환된다.
//        List<User> users = userRepository.findAll(); // userrepository 객체에 접근해서 findall이라는 메서드를 실행시킨다. -> 받아온 변수로 Users 객체를 찾아와서 users 변수에 저장한다.
//        List<UserResponseDto> userResponseList = new ArrayList<>(); // userresponsedto의 list 형식으로 반환되는 userresponselist를 생성했다
//
//        for ( int i = 0; i < users.size(); i++){
//            User use = new User(); // User클래스의 use라는 객체를 인스턴스화 했다.
//            use = users.get(i); // user에 있던것을 use에 넣어줬다.
//
//            UserResponseDto useResponseDto = new UserResponseDto(use); // UserResponseDto 클래스의 useResponseDto라는 객체를 만들었는데 파라미터 값으로 use를 받는다.
//            userResponseList.add(useResponseDto); //useResponseDto 있던 것들을 userResponseList에 넣어준다.
////            userResponseList.add(i,i)= users.get(i); // // user라는 리스트에서 순서대로 하나씩 꺼내와서
//        }
//        return userResponseList;// userResponseList를 반환한다.
//    }

    public List<UserResponseDto> findAllUser() { // 모든 클래스에 접근 가능한 findalluser 메서드. 반환값은 userresponseDto의 List로 반환한다.
        List<User> users = userRepository.findAll(); // userrepository 객체에 접근해서 findall이라는 메서드를 실행시킨다. -> findAll 메서드는 "select * from user"라는 쿼리를 발생시켜 데이터베이스에 존재하는 모든 유저 레코드를 조회하여 user 클래스 객체의 리스트를 반환한다.
        List<UserResponseDto> userResponseList = new ArrayList<>(); // userresponsedto의 list 타입을 가진 빈 어레이리스트를 생성했고, 변수명은 userResponseList이다.

        for ( int i = 0; i < users.size(); i++){
            UserResponseDto userResponseDto = new UserResponseDto(users.get(i)); // user의 i번 째 레코드를 가져와 UserResponseDto의 생성자 파라메터로 사용하여 UserResponseDto 클래스의 인스턴스를 만든다.
            userResponseList.add(userResponseDto); // 앞서 만들어 둔 userResponseList에 userResponseDto 객체를 추가한다.
        }

        return userResponseList;// userResponseList를 반환한다.
    }
}

