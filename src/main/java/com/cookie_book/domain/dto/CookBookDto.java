package com.cookie_book.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
public class CookBookDto {
    private long cookBookId;
    private String name;
    private boolean deleted;
    private Set<UserDto> userSet;
    private List<CategoryDto> categoryList;

    private CookBookDto(long cookBookId, String name, boolean deleted, Set<UserDto> userSet, List<CategoryDto> categoryList) {
        this.cookBookId = cookBookId;
        this.name = name;
        this.deleted = deleted;
        this.userSet = userSet;
        this.categoryList = categoryList;
    }

    public static class Builder {
        private long cookBookId;
        private String name;
        private boolean deleted;
        private Set<UserDto> userSet;
        private List<CategoryDto> categoryList;

        public Builder cookBookId(long cookBookId) {
            this.cookBookId = cookBookId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder deleted(boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        public Builder userSet(Set<UserDto> userDtoSet) {
            this.userSet = userDtoSet;
            return this;
        }

        public Builder categoryList(List<CategoryDto> categoryDtoList) {
            this.categoryList = categoryDtoList;
            return this;
        }

        public CookBookDto build() {
            return new CookBookDto(cookBookId, name, deleted, userSet, categoryList);
        }
    }
}
