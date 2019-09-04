package com.cookie_book.domain.dto;

import com.cookie_book.domain.Category;
import com.cookie_book.domain.Comment;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RecipeDto {
    private long recipeId;
    private byte rating;
    private LocalTime preparationTime;
    private byte portions;
    private String ingredients;
    private String tools;
    private String preparation;
    private Category category;
    private List<CommentDto> comments;

    public RecipeDto(long recipeId, byte rating, LocalTime preparationTime, byte portions, String ingredients, String tools, String preparation, Category category, List<CommentDto> comments) {
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
}
