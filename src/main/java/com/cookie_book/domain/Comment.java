package com.cookie_book.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long commentId;

    private byte rating;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Comment(byte rating, String content, User user, Recipe recipe) {
        this.rating = rating;
        this.content = content;
        this.user = user;
        this.recipe = recipe;
    }

    public static class Builder {
        private long commentId;
        private byte rating;
        private String content;
        private User user;
        private Recipe recipe;

        public Builder commentId(long commentId) {
            this.commentId = commentId;
            return this;
        }

        public Builder rating(byte rating) {
            this.rating = rating;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder userDto(User userDto) {
            this.user = userDto;
            return this;
        }

        public Builder recipeDto(Recipe recipeDto) {
            this.recipe = recipeDto;
            return this;
        }

        public Comment build() {
            return  new Comment(rating, content, user, recipe);
        }
    }
}
