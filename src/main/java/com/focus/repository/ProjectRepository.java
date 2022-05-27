package com.focus.repository;

import com.focus.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
     Project findByProjectName(String projectName);
}
