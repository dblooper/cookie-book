package com.cookie_book.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommentDto {
    private long commentId;
    private byte rating;
    private String content;
    private UserDto userDto;
    private RecipeDto recipeDto;

    private CommentDto(long commentId, byte rating, String content, UserDto userDto, RecipeDto recipeDto) {
        this.commentId = commentId;
        this.rating = rating;
        this.content = content;
        this.userDto = userDto;
        this.recipeDto = recipeDto;
    }

    public static class Builder {
        private long commentId;
        private byte rating;
        private String content;
        private UserDto userDto;
        private RecipeDto recipeDto;

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

        public Builder userDto(UserDto userDto) {
            this.userDto = userDto;
            return this;
        }

        public Builder recipeDto(RecipeDto recipeDto) {
            this.recipeDto = recipeDto;
            return this;
        }

        public CommentDto build() {
            return  new CommentDto(commentId, rating, content, userDto, recipeDto);
        }
    }
}
