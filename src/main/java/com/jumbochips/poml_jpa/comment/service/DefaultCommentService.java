package com.jumbochips.poml_jpa.comment.service;

import com.jumbochips.poml_jpa.blog.domain.Blog;
import com.jumbochips.poml_jpa.blog.repository.BlogRepository;
import com.jumbochips.poml_jpa.comment.domain.Comment;
import com.jumbochips.poml_jpa.comment.dto.CommentRequestDto;
import com.jumbochips.poml_jpa.comment.dto.CommentResponseDto;
import com.jumbochips.poml_jpa.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultCommentService implements CommentService{
    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;


    @Override
    public List<CommentResponseDto> getAllComment(Long blogId) {
        return commentRepository.findAllByBlogId(blogId).stream()
                .map(comment -> CommentResponseDto.builder()
                        .commentId(comment.getId())
                        .username(comment.getUsername())
                        .content(comment.getContent())
                        .createdAt(comment.getCreatedAt())
                        .build()).toList();
    }

    @Override
    public CommentResponseDto createComment(CommentRequestDto commentRequestDto) {
        Blog blog = blogRepository.findById(commentRequestDto.getBlogId())
                .orElseThrow(() -> new IllegalArgumentException("Blog not found"));

        Comment comment = Comment.builder()
                .blog(blog)
                .username(commentRequestDto.getUsername())
                .pwd(commentRequestDto.getPwd())
                .content(commentRequestDto.getContent())
                .build();

        commentRepository.save(comment);

        return CommentResponseDto.builder()
                .commentId(comment.getId())
                .username(comment.getUsername())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .build();
    }

    @Override
    public CommentResponseDto updateComment(Long commentId, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));

        comment.updateContent(commentRequestDto.getContent());

        commentRepository.save(comment);

        return CommentResponseDto.builder()
                .commentId(comment.getId())
                .username(comment.getUsername())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .build();
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
