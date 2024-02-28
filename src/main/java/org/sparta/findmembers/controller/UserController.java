package org.sparta.findmembers.controller;

import lombok.RequiredArgsConstructor;
import org.sparta.findmembers.dto.UserResponseDto;
import org.sparta.findmembers.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 한 회원의 userId가 주었을때 회원 정보를 조회하는 API
     * @param id
     */
    @GetMapping("/user/{userId}")
    public UserResponseDto getUserInfo(@PathVariable Long userId) {
        return userService.findUser(userId);
    }

    /**
     * 회원의 전체 목록을 조회하는 API
     */
    @GetMapping("/user")
    public String getUserList() {
        return userService.findAllUser();

    }

}