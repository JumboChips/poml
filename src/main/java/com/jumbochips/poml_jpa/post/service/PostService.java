package com.jumbochips.poml_jpa.post.service;

import com.jumbochips.poml_jpa.post.domain.Post;
import com.jumbochips.poml_jpa.post.dto.PostRequestDto;
import com.jumbochips.poml_jpa.post.dto.PostResponseDto;
import com.jumbochips.poml_jpa.post.repository.PostRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    List<PostResponseDto> getAllPost(Long userId);
    PostResponseDto getPost(Long postId);
    PostResponseDto createPost(PostRequestDto postRequestDto);
    PostResponseDto updatePost(Long postId, PostRequestDto postRequestDto);
    ResponseEntity<?> deletePost(Long postId);
}
