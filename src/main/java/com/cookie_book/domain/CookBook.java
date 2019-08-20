package com.cookie_book.domain;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Getter
public class CookBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long libraryId;

    private String name;

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

}
