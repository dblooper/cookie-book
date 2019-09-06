package com.cookie_book.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private long userId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    private byte status;
    private Set<CookBookDto> cookBookSet = new HashSet<>();
    private List<CommentDto> commentList = new ArrayList<>();

    public UserDto(long userId, String name, String email, byte status, Set<CookBookDto> cookBookSet, List<CommentDto> commentList) {
        this.userId = userId;
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
        private Set<CookBookDto> cookBookSet = new HashSet<>();
        private List<CommentDto> commentList = new ArrayList<>();

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
            return new UserDto(userId, name, email, status, cookBookSet, commentList);
        }
    }
}
