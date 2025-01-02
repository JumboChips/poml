package com.jumbochips.poml_jpa.project.service;

import com.jumbochips.poml_jpa.project.dto.ProjectRequestDto;
import com.jumbochips.poml_jpa.project.dto.ProjectResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectService {
    List<ProjectResponseDto> getAllProject();
    ProjectResponseDto getProject(Long blogId);
    ProjectResponseDto createProject(ProjectRequestDto blogRequestDto);
    ProjectResponseDto updateProject(Long blogId, ProjectRequestDto blogRequestDto);
    ResponseEntity<?> deleteProject(Long blogId);
}
