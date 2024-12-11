package com.jumbochips.poml_jpa.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    private Long categoryId;
    private String thumbnail;
    private String title;
    private String content;
}
