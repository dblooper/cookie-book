package com.cookie_book.mapper;

import com.cookie_book.domain.User;
import com.cookie_book.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User mapUserDtoToUser(UserDto userDto) {
        return new User.Builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .build();
    }

    public UserDto mapUserToUserDto(User user) {
        return new UserDto.Builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .status(user.getStatus())
                .build();
    }

    public List<UserDto> mapUserListToUserDtoList(List<User> userList) {
        return userList.stream()
                .map(user -> mapUserToUserDto(user))
                .collect(Collectors.toList());
    }

}
