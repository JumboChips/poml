package com.jumbochips.poml_jpa.post.repository;

import com.jumbochips.poml_jpa.post.domain.Post;
import com.jumbochips.poml_jpa.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
}
