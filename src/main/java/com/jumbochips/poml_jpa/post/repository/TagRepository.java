package com.jumbochips.poml_jpa.post.repository;

import com.jumbochips.poml_jpa.post.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
