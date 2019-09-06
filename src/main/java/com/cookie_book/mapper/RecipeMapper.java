package com.cookie_book.mapper;

import com.cookie_book.domain.Recipe;
import com.cookie_book.domain.dto.RecipeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecipeMapper {
    @Autowired
    private CommentsMapper commentsMapper;

    public RecipeDto mapRecipeToRecipeDto(Recipe recipe) {
        return new RecipeDto.Builder()
                .recipeId(recipe.getRecipeId())
                .comments(commentsMapper.mapCommentListToCommentDtoList(recipe.getComments()))
                .portions(recipe.getPortions())
                .preparation(recipe.getPreparation())
                .ingredinets(recipe.getIngredients())
                .tools(recipe.getTools())
                .rating(recipe.getRating())
                .build();
    }

    List<RecipeDto> mapRecipeListToRecipeDtoList(List<Recipe> recipeList) {
        return recipeList.stream()
                .map(recipe -> mapRecipeToRecipeDto(recipe))
                .collect(Collectors.toList());
    }
}
