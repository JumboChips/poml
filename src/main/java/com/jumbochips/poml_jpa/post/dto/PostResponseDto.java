package com.jumbochips.poml_jpa.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    private Long postId;
    private Long categoryId;
    private String thumbnail;
    private String title;
    private String content;
    private List<Long> tagIds; // 태그 ID 리스트

}
