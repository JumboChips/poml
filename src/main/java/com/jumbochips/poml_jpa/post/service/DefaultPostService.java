package com.jumbochips.poml_jpa.post.service;

import com.jumbochips.poml_jpa.post.domain.Category;
import com.jumbochips.poml_jpa.post.domain.Post;
import com.jumbochips.poml_jpa.post.domain.PostTag;
import com.jumbochips.poml_jpa.post.domain.Tag;
import com.jumbochips.poml_jpa.post.dto.PostRequestDto;
import com.jumbochips.poml_jpa.post.dto.PostResponseDto;
import com.jumbochips.poml_jpa.post.repository.CategoryRepository;
import com.jumbochips.poml_jpa.post.repository.PostRepository;
import com.jumbochips.poml_jpa.post.repository.PostTagRepository;
import com.jumbochips.poml_jpa.post.repository.TagRepository;
import com.jumbochips.poml_jpa.user.domain.User;
import com.jumbochips.poml_jpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultPostService implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;
    private final PostTagRepository postTagRepository;

    @Override
    public List<PostResponseDto> getAllPost() {
        List<Post> posts = postRepository.findAll();

        return posts.stream()
                .map(post -> new PostResponseDto(
                        post.getId(),
                        post.getCategory().getId(),
                        post.getThumbnail(),
                        post.getTitle(),
                        post.getContent(),
                        post.getPostTags().stream()
                                .map(postTag -> postTag.getTag().getId())
                                .toList()
                )).collect(Collectors.toList());
    }

    @Override
    public PostResponseDto getPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return PostResponseDto.builder()
                .categoryId(post.getCategory().getId())
                .thumbnail(post.getThumbnail())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    @Override
    public PostResponseDto createPost(PostRequestDto postRequestDto) {
        User user = userRepository.findById(postRequestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("user not found"));

        Category category = categoryRepository.findById(postRequestDto.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("category not found"));


        Post post = Post.builder()
                .user(user)
                .thumbnail(postRequestDto.getThumbnail())
                .title(postRequestDto.getTitle())
                .content(postRequestDto.getContent())
                .category(category)
                .build();

        postRepository.save(post);

        List<Long> tagIds = postRequestDto.getTagIds();
        List<Tag> tags = tagRepository.findAllById(tagIds);

        List<PostTag> postTags = tags.stream()
                .map(tag -> PostTag.builder()
                        .post(post)
                        .tag(tag)
                        .build()
                ).toList();

        postTagRepository.saveAll(postTags);


        return PostResponseDto.builder()
                .postId(post.getId())
                .categoryId(post.getCategory().getId())
                .thumbnail(post.getThumbnail())
                .title(post.getTitle())
                .content(post.getContent())
                .tagIds(tags.stream().map(Tag::getId).collect(Collectors.toList()))
                .build();
    }

    @Override
    public PostResponseDto updatePost(Long postId, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Category category = categoryRepository.findById(postRequestDto.getCategoryId())
                        .orElseThrow(() -> new IllegalArgumentException("category not found"));

        // 기존 PostTag 삭제
        postTagRepository.deleteByPostId(postId);

        // 새로운 태그 추가
        List<Long> tagIds = postRequestDto.getTagIds();
        List<Tag> tags = tagRepository.findAllById(tagIds);

        List<PostTag> newPostTags = tags.stream()
                .map(tag -> PostTag.builder()
                        .post(post)
                        .tag(tag)
                        .build())
                .collect(Collectors.toList());

        postTagRepository.saveAll(newPostTags);

        post.updateTitle(postRequestDto.getTitle());
        post.updateContent(postRequestDto.getContent());
        post.updateThumbnail(postRequestDto.getThumbnail());
        post.updateCategory(category);
        postRepository.save(post);

        return PostResponseDto.builder()
                .postId(post.getId())
                .categoryId(post.getCategory().getId())
                .thumbnail(post.getThumbnail())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    @Override
    public ResponseEntity<?> deletePost(Long postId) {
        postRepository.deleteById(postId);
        return ResponseEntity.ok().build();
    }

}
