package com.cookie_book.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long recipeId;

    private byte rating;
    private LocalTime preparationTime;
    private byte portions;
    private String ingredients;
    private String tools;
    private String preparation;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(
            targetEntity = Comment.class,
            mappedBy = "recipe",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Comment> comments = new ArrayList<>();
}
