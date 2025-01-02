package com.jumbochips.poml_jpa.project.repository;

import com.jumbochips.poml_jpa.project.domain.ProjectTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectTagRepository extends JpaRepository<ProjectTag, Long> {
}
