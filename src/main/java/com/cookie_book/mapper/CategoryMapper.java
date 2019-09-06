package com.cookie_book.mapper;

import com.cookie_book.domain.Category;
import com.cookie_book.domain.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {
    @Autowired
    private RecipeMapper recipeMapper;

    public CategoryDto mapCategoryToCategoryDto(Category category) {
        return new CategoryDto(category.getCategoryId(), recipeMapper.mapRecipeListToRecipeDtoList(category.getRecipeList()));
    }

    public List<CategoryDto> mapCategoryListToCategoryDtoList(List<Category> categoryList) {
        return categoryList.stream()
                .map(category -> mapCategoryToCategoryDto(category))
                .collect(Collectors.toList());
    }
}
