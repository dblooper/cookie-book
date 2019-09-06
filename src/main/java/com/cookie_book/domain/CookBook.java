package com.cookie_book.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cook_books")
@NoArgsConstructor
@Getter
public class CookBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long cookBookId;

    private String name;

    private boolean deleted;

    @ManyToMany(cascade = CascadeType.ALL,
                mappedBy = "cookBookSet")
    private Set<User> userSet = new HashSet<>();

    @ManyToMany(
            cascade = CascadeType.ALL)
    @JoinTable(
            name = "join_cook_books_categories",
            joinColumns = {
                    @JoinColumn(name = "category_id",
                                referencedColumnName = "id"
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "cook_book_id",
                                referencedColumnName = "id"
                    )
            }
    )
    private List<Category> categoryList = new ArrayList<>();

    public void setDeleted() {
        this.deleted = true;
    }

    private CookBook(String name, boolean deleted, Set<User> userSet, List<Category> categoryList) {
        this.name = name;
        this.deleted = deleted;
        this.userSet = userSet;
        this.categoryList = categoryList;
    }

    public static class Builder {
        private String name;
        private boolean deleted;
        private Set<User> userSet;
        private List<Category> categoryList;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder deleted(boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        public Builder userSet(Set<User> userDtoSet) {
            this.userSet = userDtoSet;
            return this;
        }

        public Builder categoryList(List<Category> categoryDtoList) {
            this.categoryList = categoryDtoList;
            return this;
        }

        public CookBook build() {
            return new CookBook(name, deleted, userSet, categoryList);
        }
    }
}
