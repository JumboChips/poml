package com.jumbochips.poml_jpa.blog.repository;

import com.jumbochips.poml_jpa.blog.domain.BlogPostTag;
import com.jumbochips.poml_jpa.blog.domain.BlogTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostTagRepository extends JpaRepository<BlogPostTag, Long> {
    void deleteByBlogId(Long blogId);
}
