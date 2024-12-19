package com.jumbochips.poml_jpa.comment.dto;

import java.time.LocalDateTime;

public class CommentResponseDto {
    private Long userId;
    private String userProfilePicture;
    private String content;
    private LocalDateTime createdAt;
}
