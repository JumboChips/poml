package com.jumbochips.poml_jpa.blog.repository;

import com.jumbochips.poml_jpa.blog.domain.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogCategoryRepository extends JpaRepository<BlogCategory, Long> {
}
