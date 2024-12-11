package com.jumbochips.poml_jpa.post.controller;

import com.jumbochips.poml_jpa.post.dto.PostRequestDto;
import com.jumbochips.poml_jpa.post.dto.PostResponseDto;
import com.jumbochips.poml_jpa.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getAllPost(
            @RequestParam Long userId
    ) {
        try {
            List<PostResponseDto> postResponseDtos = postService.getAllPost(userId);
            return ResponseEntity.ok(postResponseDtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("{postId}")
    public ResponseEntity<PostResponseDto> getPostById(
            @PathVariable Long postId
    ){
        try {
            PostResponseDto postResponseDto = postService.getPost(postId);
            return ResponseEntity.ok(postResponseDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(
            @RequestBody PostRequestDto postRequestDto
    ) {
        try {
            PostResponseDto postResponseDto = postService.createPost(postRequestDto);
            return ResponseEntity.ok(postResponseDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("{postId}")
    public ResponseEntity<PostResponseDto> updatePost(
            @PathVariable Long postId,
            @RequestBody PostRequestDto postRequestDto
    ) {
        try {
            PostResponseDto postResponseDto = postService.updatePost(postId, postRequestDto);
            return ResponseEntity.ok(postResponseDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<PostResponseDto> deletePost(
            @PathVariable Long postId
    ) {
        try {
            postService.deletePost(postId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
