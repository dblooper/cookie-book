package com.cookie_book.domain.dto;

import com.cookie_book.domain.Category;
import com.cookie_book.domain.User;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CookBookDto {
    private long cookBookId;
    private String name;
    private boolean deleted;
    private Set<User> userSet;
    private List<Category> categoryList;

    public CookBookDto(long cookBookId, String name, boolean deleted, Set<User> userSet, List<Category> categoryList) {
        this.cookBookId = cookBookId;
        this.name = name;
        this.deleted = deleted;
        this.userSet = userSet;
        this.categoryList = categoryList;
    }
}
