package com.cookie_book.service;

import com.cookie_book.domain.CookBook;
import com.cookie_book.exceptions.CookBookNotFoundException;
import com.cookie_book.repository.CookBookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CookBookService {

    private CookBookRepository cookBookRepository;

    @Autowired
    public CookBookService(CookBookRepository cookBookRepository) {
        this.cookBookRepository = cookBookRepository;
    }

    public void addCookBook(CookBook cookBook) {
        cookBookRepository.save(cookBook);
    }

    public CookBook removeCookBook(CookBook cookBook) throws CookBookNotFoundException {
        cookBookRepository.findById(cookBook.getCookBookId()).ifPresent(
                book -> {
                    if(!book.isDeleted()) book.setDeleted();
                    cookBookRepository.save(book);
                }
        );
        return cookBookRepository.findById(cookBook.getCookBookId()).orElseThrow(CookBookNotFoundException::new);
    }

    public List<CookBook> getListOfBooksFromTheArchive() {
        return cookBookRepository.findAll().stream()
                .filter(CookBook::isDeleted)
                .collect(Collectors.toList());
    }
}
