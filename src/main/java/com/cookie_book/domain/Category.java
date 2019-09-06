package com.cookie_book.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long categoryId;

    @ManyToMany(cascade = CascadeType.ALL,
                mappedBy = "categoryList")
    private List<CookBook> cookBookList = new ArrayList<>();

    @OneToMany(
            targetEntity = Recipe.class,
            mappedBy = "category",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Recipe> recipeList = new ArrayList<>();

    public Category(List<CookBook> cookBookList, List<Recipe> recipeList) {
        this.cookBookList = cookBookList;
        this.recipeList = recipeList;
    }
}
