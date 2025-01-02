package com.jumbochips.poml_jpa.comment.controller;

import com.jumbochips.poml_jpa.comment.dto.CommentRequestDto;
import com.jumbochips.poml_jpa.comment.dto.CommentResponseDto;
import com.jumbochips.poml_jpa.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> getComment(
            @RequestParam Long blogId
    ) {
        try {
        List<CommentResponseDto> commentResponseDtos = commentService.getAllComment(blogId);
            return ResponseEntity.ok(commentResponseDtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<CommentResponseDto> createComment(
            @RequestBody CommentRequestDto commentRequestDto
    ) {
        try {
            CommentResponseDto commentResponseDto = commentService.createComment(commentRequestDto);
            return ResponseEntity.ok(commentResponseDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("{commentId}")
    public ResponseEntity<CommentResponseDto> updateComment(
            @PathVariable Long commentId,
            @RequestBody CommentRequestDto commentRequestDto
    ) {
        try {
            CommentResponseDto commentResponseDto = commentService.updateComment(commentId, commentRequestDto);
            return ResponseEntity.ok(commentResponseDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{commentId}")
    public ResponseEntity<CommentResponseDto> deleteComment(
            @PathVariable Long commentId
    ) {
        try {
            commentService.deleteComment(commentId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
