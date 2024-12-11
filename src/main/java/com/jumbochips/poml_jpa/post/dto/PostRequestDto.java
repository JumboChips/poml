package com.jumbochips.poml_jpa.post.dto;

import com.jumbochips.poml_jpa.post.domain.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDto {
    private Long userId;
    private Long categoryId;
    private List<Long> tagIds;
    private String thumbnail;
    private String title;
    private String content;

}
