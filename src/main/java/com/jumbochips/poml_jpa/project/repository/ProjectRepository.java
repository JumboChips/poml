package com.jumbochips.poml_jpa.project.repository;

import com.jumbochips.poml_jpa.blog.domain.Blog;
import com.jumbochips.poml_jpa.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByUserId(Long userId);
}
