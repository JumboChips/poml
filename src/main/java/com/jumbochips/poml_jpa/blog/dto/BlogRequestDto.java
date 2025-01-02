package com.jumbochips.poml_jpa.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogRequestDto {
    private Long userId;
    private Long categoryId;
    private List<Long> tagIds;
    private String thumbnail;
    private String title;
    private String content;
    private List<String> imageUrls;
}
