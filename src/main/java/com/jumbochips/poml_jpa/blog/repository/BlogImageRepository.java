package com.jumbochips.poml_jpa.blog.repository;

import com.jumbochips.poml_jpa.blog.domain.BlogImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogImageRepository extends JpaRepository<BlogImage, Long> {
}
