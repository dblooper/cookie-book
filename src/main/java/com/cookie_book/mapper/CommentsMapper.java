package com.cookie_book.mapper;

import com.cookie_book.domain.Comment;
import com.cookie_book.domain.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentsMapper {
    @Autowired
    private UserMapper userMapper;

    public List<CommentDto> mapCommentListToCommentDtoList(List<Comment> commentList) {
        return commentList.stream()
                .map(comment -> new CommentDto.Builder()
                .commentId(comment.getCommentId())
                .content(comment.getContent())
                .rating(comment.getRating())
                .userDto(userMapper.mapUserToUserDto(comment.getUser()))
                .build())
                .collect(Collectors.toList());
    }
}
