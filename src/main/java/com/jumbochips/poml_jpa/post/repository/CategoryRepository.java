package com.jumbochips.poml_jpa.post.repository;

import com.jumbochips.poml_jpa.post.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
