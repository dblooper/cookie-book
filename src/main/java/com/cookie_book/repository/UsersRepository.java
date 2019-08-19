package com.cookie_book.repository;

import com.cookie_book.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}
