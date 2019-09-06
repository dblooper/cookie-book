package com.cookie_book.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
@NoArgsConstructor
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

    @Column(columnDefinition = "TEXT")
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

    private Recipe(byte rating, LocalTime preparationTime, byte portions, String ingredients, String tools, String preparation, Category category, List<Comment> comments) {
        this.rating = rating;
        this.preparationTime = preparationTime;
        this.portions = portions;
        this.ingredients = ingredients;
        this.tools = tools;
        this.preparation = preparation;
        this.category = category;
        this.comments = comments;
    }

    public static class Builder {
        private byte rating;
        private LocalTime preparationTime;
        private byte portions;
        private String ingredients;
        private String tools;
        private String preparation;
        private Category category;
        private List<Comment> comments;

        public Builder rating(byte rating) {
            this.rating = rating;
            return this;
        }

        public Builder preparationtime(LocalTime preparationTime) {
            this.preparationTime = preparationTime;
            return this;
        }

        public Builder portions(byte portions) {
            this.portions = portions;
            return this;
        }

        public Builder ingredinets(String ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public Builder tools(String tools) {
            this.tools = tools;
            return this;
        }

        public Builder preparation(String preparation) {
            this.preparation = preparation;
            return this;
        }

        public Builder category(Category category) {
            this.category = category;
            return this;
        }

        public Builder comments(List<Comment> commentList) {
            this.comments = commentList;
            return this;
        }

        public Recipe build() {
            return new Recipe(rating, preparationTime, portions, ingredients, tools, preparation, category, comments);
        }

    }


}
