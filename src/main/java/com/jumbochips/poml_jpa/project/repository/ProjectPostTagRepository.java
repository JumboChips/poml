package com.jumbochips.poml_jpa.project.repository;

import com.jumbochips.poml_jpa.blog.domain.BlogTag;
import com.jumbochips.poml_jpa.project.domain.ProjectPostTag;
import com.jumbochips.poml_jpa.project.domain.ProjectTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectPostTagRepository extends JpaRepository<ProjectPostTag, Long> {
    void deleteByProjectId(Long blogId);
}
