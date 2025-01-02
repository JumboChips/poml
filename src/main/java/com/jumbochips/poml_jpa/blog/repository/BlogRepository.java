package com.jumbochips.poml_jpa.blog.repository;

import com.jumbochips.poml_jpa.blog.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByUserId(Long userId);
}
