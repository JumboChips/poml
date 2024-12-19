package com.jumbochips.poml_jpa.comment.service;

import com.jumbochips.poml_jpa.comment.domain.Comment;
import com.jumbochips.poml_jpa.comment.dto.CommentRequestDto;
import com.jumbochips.poml_jpa.comment.dto.CommentResponseDto;
import com.jumbochips.poml_jpa.comment.repository.CommentRepository;
import com.jumbochips.poml_jpa.guestBook.domain.GuestBook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultCommentService implements CommentService{
    private final CommentRepository commentRepository;


    @Override
    public CommentResponseDto getComment() {
        return null;
    }

    @Override
    public CommentResponseDto createComment(CommentRequestDto commentRequestDto) {
        return null;
    }

    @Override
    public CommentResponseDto updateComment(Long commentId, CommentRequestDto commentRequestDto) {
        return null;
    }

    @Override
    public void deleteComment(Long commentId) {

    }
}
