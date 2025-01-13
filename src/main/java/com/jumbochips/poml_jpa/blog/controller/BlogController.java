package com.jumbochips.poml_jpa.blog.controller;

import com.jumbochips.poml_jpa.blog.dto.BlogRequestDto;
import com.jumbochips.poml_jpa.blog.dto.BlogResponseDto;
import com.jumbochips.poml_jpa.blog.service.BlogService;
import com.jumbochips.poml_jpa.common.auth.dto.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/v1/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping
    public ResponseEntity<List<BlogResponseDto>> getAllBlog() {
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
            @RequestBody BlogRequestDto blogRequestDto,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        try {
            // userDetails가 null인지 확인
            if (userDetails == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }

            // 인증된 사용자 정보에서 userId 추출
            Long userId = userDetails.getUserId();
            blogRequestDto.setUserId(userId);

            System.out.println("userDetails: " + userDetails.getUsername());
            System.out.println(userDetails);

            BlogResponseDto blogResponseDto = blogService.createBlog(blogRequestDto);
            return ResponseEntity.ok(blogResponseDto);
        } catch (Exception e) {
            e.printStackTrace();
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
