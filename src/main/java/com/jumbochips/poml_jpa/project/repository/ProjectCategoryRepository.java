package com.jumbochips.poml_jpa.project.repository;

import com.jumbochips.poml_jpa.project.domain.ProjectCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectCategoryRepository extends JpaRepository<ProjectCategory, Long> {
}
