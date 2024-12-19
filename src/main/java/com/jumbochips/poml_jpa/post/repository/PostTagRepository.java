package com.jumbochips.poml_jpa.post.repository;

import com.jumbochips.poml_jpa.post.domain.PostTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostTagRepository extends JpaRepository<PostTag, Long> {
    void deleteByPostId(Long postId);
}
