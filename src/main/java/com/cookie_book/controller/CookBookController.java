package com.cookie_book.controller;

import com.cookie_book.domain.User;
import com.cookie_book.domain.dto.UserDto;
import com.cookie_book.mapper.UserMapper;
import com.cookie_book.repository.UsersRepository;
import com.cookie_book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class CookBookController {

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public CookBookController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/cookie-book/user")
    public List<User> fetchUsers() {
        return new ArrayList<>();
    }

    @PostMapping(value = "/cookie-book/user/add")
    public void addUser(UserDto userDto) {
         userMapper.mapUserDtoToUser(userDto);
    }
}
