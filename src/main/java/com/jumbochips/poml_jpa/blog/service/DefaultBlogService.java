package com.jumbochips.poml_jpa.blog.service;

import com.jumbochips.poml_jpa.blog.domain.*;
import com.jumbochips.poml_jpa.blog.dto.BlogResponseDto;
import com.jumbochips.poml_jpa.blog.repository.*;
import com.jumbochips.poml_jpa.blog.dto.BlogRequestDto;
import com.jumbochips.poml_jpa.user.domain.User;
import com.jumbochips.poml_jpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultBlogService implements BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;
    private final BlogCategoryRepository categoryRepository;
    private final BlogTagRepository blogTagRepository;
    private final BlogPostTagRepository blogPostTagRepository;
    private final BlogImageRepository blogImageRepository;

    @Override
    public List<BlogResponseDto> getAllBlog() {
        List<Blog> blogs = blogRepository.findAll();

        return blogs.stream()
                .map(blog -> new BlogResponseDto(
                        blog.getId(),
                        blog.getCategory().getId(),
                        blog.getThumbnail(),
                        blog.getTitle(),
                        blog.getContent(),
                        blog.getBlogPostTags().stream()
                                .map(blogTag -> blogTag.getTag().getId())
                                .toList()
                )).collect(Collectors.toList());
    }

    @Override
    public BlogResponseDto getBlog(Long blogId) {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new RuntimeException("Blog not found"));
        return BlogResponseDto.builder()
                .categoryId(blog.getCategory().getId())
                .thumbnail(blog.getThumbnail())
                .title(blog.getTitle())
                .content(blog.getContent())
                .build();
    }

    @Override
    public BlogResponseDto createBlog(BlogRequestDto blogRequestDto) {
        User user = userRepository.findById(blogRequestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("user not found"));

        BlogCategory category = categoryRepository.findById(blogRequestDto.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("category not found"));


        Blog blog = Blog.builder()
                .user(user)
                .thumbnail(blogRequestDto.getThumbnail())
                .title(blogRequestDto.getTitle())
                .content(blogRequestDto.getContent())
                .category(category)
                .build();

        blogRepository.save(blog);

        List<Long> tagIds = blogRequestDto.getTagIds();
        List<BlogTag> tags = blogTagRepository.findAllById(tagIds);

        List<BlogPostTag> blogTags = tags.stream()
                .map(tag -> BlogPostTag.builder()
                        .blog(blog)
                        .tag(tag)
                        .build()
                ).toList();

        blogPostTagRepository.saveAll(blogTags);

        // 이미지 URL 저장

        List<BlogImage> images = blogRequestDto.getImageUrls().stream()
                .map(url -> BlogImage.builder()
                        .blog(blog)
                        .imageUrl(url)
                        .build())
                .collect(Collectors.toList());
        blogImageRepository.saveAll(images);


        return BlogResponseDto.builder()
                .blogId(blog.getId())
                .categoryId(blog.getCategory().getId())
                .thumbnail(blog.getThumbnail())
                .title(blog.getTitle())
                .content(blog.getContent())
                .tagIds(tags.stream().map(BlogTag::getId).collect(Collectors.toList()))
                .build();
    }

    @Override
    public BlogResponseDto updateBlog(Long blogId, BlogRequestDto blogRequestDto) {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        BlogCategory category = categoryRepository.findById(blogRequestDto.getCategoryId())
                        .orElseThrow(() -> new IllegalArgumentException("category not found"));

        // 기존 BlogTag 삭제
        blogPostTagRepository.deleteByBlogId(blogId);

        // 새로운 태그 추가
        List<Long> tagIds = blogRequestDto.getTagIds();
        List<BlogTag> tags = blogTagRepository.findAllById(tagIds);

        List<BlogPostTag> newBlogTags = tags.stream()
                .map(tag -> BlogPostTag.builder()
                        .blog(blog)
                        .tag(tag)
                        .build())
                .collect(Collectors.toList());

        blogPostTagRepository.saveAll(newBlogTags);

        blog.updateTitle(blogRequestDto.getTitle());
        blog.updateContent(blogRequestDto.getContent());
        blog.updateCategory(category);
        blogRepository.save(blog);

        return BlogResponseDto.builder()
                .blogId(blog.getId())
                .categoryId(blog.getCategory().getId())
                .thumbnail(blog.getThumbnail())
                .title(blog.getTitle())
                .content(blog.getContent())
                .build();
    }

    @Override
    public ResponseEntity<?> deleteBlog(Long blogId) {
        blogRepository.deleteById(blogId);
        return ResponseEntity.ok().build();
    }

}
