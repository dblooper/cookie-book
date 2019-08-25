package com.cookie_book.repository;

import com.cookie_book.domain.CookBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookBookRepository extends JpaRepository<CookBook, Long> {

}
