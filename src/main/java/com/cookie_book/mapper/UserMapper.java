package com.cookie_book.mapper;

import com.cookie_book.domain.User;
import com.cookie_book.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    public User mapUserDtoToUser(UserDto userDto) {
        return new User.Builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .build();
    }

}
