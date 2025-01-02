package com.jumbochips.poml_jpa.comment.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class CommentResponseDto {
    private Long commentId;
    private String username;
    private String content;
    private LocalDateTime createdAt;
}
