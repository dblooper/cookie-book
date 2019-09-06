package com.cookie_book.service;

import com.cookie_book.domain.User;
import com.cookie_book.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> fetchAllUsers() {
        return usersRepository.findAll();
    }

    public void addUser(User user) {
        usersRepository.save(user);
    }
}
