package com.jumbochips.poml_jpa.blog.controller;

import com.jumbochips.poml_jpa.blog.dto.BlogRequestDto;
import com.jumbochips.poml_jpa.blog.dto.BlogResponseDto;
import com.jumbochips.poml_jpa.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping
    public ResponseEntity<List<BlogResponseDto>> getAllBlog(
            @RequestParam Long userId
    ) {
        try {
            List<BlogResponseDto> blogResponseDtos = blogService.getAllBlog();
            return ResponseEntity.ok(blogResponseDtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("{blogId}")
    public ResponseEntity<BlogResponseDto> getBlogById(
            @PathVariable Long blogId
    ){
        try {
            BlogResponseDto blogResponseDto = blogService.getBlog(blogId);
            return ResponseEntity.ok(blogResponseDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<BlogResponseDto> createBlog(
            @RequestBody BlogRequestDto blogRequestDto
    ) {
        try {
            BlogResponseDto blogResponseDto = blogService.createBlog(blogRequestDto);
            return ResponseEntity.ok(blogResponseDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("{blogId}")
    public ResponseEntity<BlogResponseDto> updateBlog(
            @PathVariable Long blogId,
            @RequestBody BlogRequestDto blogRequestDto
    ) {
        try {
            BlogResponseDto blogResponseDto = blogService.updateBlog(blogId, blogRequestDto);
            return ResponseEntity.ok(blogResponseDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{blogId}")
    public ResponseEntity<BlogResponseDto> deleteBlog(
            @PathVariable Long blogId
    ) {
        try {
            blogService.deleteBlog(blogId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
