package com.cookie_book.mapper;

import com.cookie_book.domain.CookBook;
import com.cookie_book.domain.dto.CookBookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CookBookMapper {
    @Autowired
    private CategoryMapper categoryMapper;

    public CookBookDto mapCookBookToCookBookDto(CookBook cookBook) {
        return new CookBookDto.Builder()
                .cookBookId(cookBook.getCookBookId())
                .name(cookBook.getName())
                .categoryList(categoryMapper.mapCategoryListToCategoryDtoList(cookBook.getCategoryList()))
                .deleted(cookBook.isDeleted())
                .build();
    }

    public Set<CookBookDto> mapCookBookListToCookBookDtoList(Set<CookBook> cookBookList) {
        return cookBookList.stream()
                .map(cookBook -> mapCookBookToCookBookDto(cookBook))
                .collect(Collectors.toSet());
    }
}
