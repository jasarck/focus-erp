package com.focus.service;

import com.focus.model.Project;


import java.util.List;

public interface ProjectService {

    Project saveProject(Project project);

    Project updateProject(Project project);

    Project getProject(String projectName);
    List<Project> getProjects();

    Project getProjectById(Long id);

    boolean delete(Long id);
}
