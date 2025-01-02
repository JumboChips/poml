package com.jumbochips.poml_jpa.blog.repository;

import com.jumbochips.poml_jpa.blog.domain.BlogTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogTagRepository extends JpaRepository<BlogTag, Long> {
}
