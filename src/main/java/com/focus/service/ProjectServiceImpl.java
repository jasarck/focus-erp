package com.focus.service;

import com.focus.model.Project;
import com.focus.model.User;
import com.focus.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

import static java.lang.Boolean.TRUE;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    @Override
    public Project saveProject(Project project) {
        log.info("Saving Server Info {}", project.getProjectName());
        project.setImageUrl(setProjectImageURL());
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Project project) {
        log.info("Saving Server Info {}", project.getProjectName());
        project.setImageUrl(setProjectImageURL());
        return projectRepository.save(project);
    }

    @Override
    public Project getProject(String projectName) {

        log.info("Fetch Project By", projectName);
        return projectRepository.findByProjectName(projectName);
    }

    @Override
    public List<Project> getProjects() {
        log.info("Fetch All Project");
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long id) {

        log.info("Fetch Project By", id);
        return projectRepository.findById(id).get();
    }


    @Override
    public boolean delete(Long id) {
        log.info("Deleting Project By ID {}", id);
        projectRepository.deleteById(id);
        return TRUE;
    }

    private String setProjectImageURL() {
        String[] images = {"serve1.png" , "serve1.png" , "serve1.png" , "serve1.png" };
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/"+images[new Random().nextInt(4)]).toUriString();
    }
}
