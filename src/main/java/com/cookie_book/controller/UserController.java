package com.cookie_book.controller;

import com.cookie_book.domain.dto.UserDto;
import com.cookie_book.mapper.UserMapper;
import com.cookie_book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cookie-book")
@CrossOrigin("*")
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping(value = "/users")
    public List<UserDto> fetchUsers() {
        return userMapper.mapUserListToUserDtoList(userService.fetchAllUsers());
    }

    @PostMapping(value = "/user/add")
    public void addUser(@RequestBody UserDto userDto) {
         userService.addUser(userMapper.mapUserDtoToUser(userDto));
    }
}
