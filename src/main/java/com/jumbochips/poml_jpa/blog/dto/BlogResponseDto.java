package com.jumbochips.poml_jpa.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogResponseDto {
    private Long blogId;
    private Long categoryId;
    private String thumbnail;
    private String title;
    private String content;
    private List<Long> tagIds; // 태그 ID 리스트

}
