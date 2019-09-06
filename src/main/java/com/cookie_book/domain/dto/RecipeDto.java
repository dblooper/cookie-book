package com.cookie_book.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@Getter
public class RecipeDto {
    private long recipeId;
    private byte rating;
    private LocalTime preparationTime;
    private byte portions;
    private String ingredients;
    private String tools;
    private String preparation;
    private CategoryDto category;
    private List<CommentDto> comments;

    private RecipeDto(long recipeId, byte rating, LocalTime preparationTime, byte portions, String ingredients, String tools, String preparation, CategoryDto category, List<CommentDto> comments) {
        this.recipeId = recipeId;
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
        private long recipeId;
        private byte rating;
        private LocalTime preparationTime;
        private byte portions;
        private String ingredients;
        private String tools;
        private String preparation;
        private CategoryDto category;
        private List<CommentDto> comments;

        public Builder recipeId(long recipeId) {
            this.recipeId = recipeId;
            return this;
        }

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

        public Builder category(CategoryDto category) {
            this.category = category;
            return this;
        }

        public Builder comments(List<CommentDto> commentList) {
            this.comments = commentList;
            return this;
        }

        public RecipeDto build() {
            return new RecipeDto(recipeId, rating, preparationTime, portions, ingredients, tools, preparation, category, comments);
        }

    }
}
