package com.cookie_book.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class CategoryDto {

    private long categoryId;
    private List<RecipeDto> recipeList;

    public CategoryDto(long categoryId, List<RecipeDto> recipeList) {
        this.categoryId = categoryId;
        this.recipeList = recipeList;
    }
}
