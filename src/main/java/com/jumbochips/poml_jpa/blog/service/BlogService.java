package com.jumbochips.poml_jpa.blog.service;

import com.jumbochips.poml_jpa.blog.dto.BlogRequestDto;
import com.jumbochips.poml_jpa.blog.dto.BlogResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BlogService {
    List<BlogResponseDto> getAllBlog();
    BlogResponseDto getBlog(Long blogId);
    BlogResponseDto createBlog(BlogRequestDto blogRequestDto);
    BlogResponseDto updateBlog(Long blogId, BlogRequestDto blogRequestDto);
    ResponseEntity<?> deleteBlog(Long blogId);
}
