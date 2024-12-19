package com.jumbochips.poml_jpa.comment.service;

import com.jumbochips.poml_jpa.comment.domain.Comment;
import com.jumbochips.poml_jpa.comment.dto.CommentRequestDto;
import com.jumbochips.poml_jpa.comment.dto.CommentResponseDto;
import com.jumbochips.poml_jpa.guestBook.domain.GuestBook;

public interface CommentService {
    CommentResponseDto getComment();
    CommentResponseDto createComment (CommentRequestDto commentRequestDto);
    CommentResponseDto updateComment (Long commentId, CommentRequestDto commentRequestDto);
    void deleteComment (Long commentId);
}
