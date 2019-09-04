package com.cookie_book.domain.dto;

import com.cookie_book.domain.Comment;
import com.cookie_book.domain.CookBook;
import com.cookie_book.domain.User;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class UserDto {

    private long userId;
    private String name;
    private String email;
    private byte status;
    private Set<CookBookDto> cookBookSet;
    private List<CommentDto> commentList;

    public UserDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UserDto(String name, String email, byte status, Set<CookBookDto> cookBookSet, List<CommentDto> commentList) {
        this.name = name;
        this.email = email;
        this.status = status;
        this.cookBookSet = cookBookSet;
        this.commentList = commentList;
    }

    public static class Builder {
        private long userId;
        private String name;
        private String email;
        private byte status;
        private Set<CookBookDto> cookBookSet;
        private List<CommentDto> commentList;

        public Builder userId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder status(byte status) {
            this.status = status;
            return this;
        }

        public Builder cookBooks(Set<CookBookDto> cookBookSet) {
            this.cookBookSet = cookBookSet;
            return this;
        }

        public Builder commentList(List<CommentDto> commentList) {
            this.commentList = commentList;
            return this;
        }

        public UserDto build() {
            return new UserDto(name, email, status, cookBookSet, commentList);
        }
    }
}
