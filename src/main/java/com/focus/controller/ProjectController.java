package com.focus.controller;

import com.focus.model.Project;
import com.focus.model.Response;
import com.focus.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/project")
@Slf4j
public class ProjectController {
    final private ProjectService projectService;

    @GetMapping("/list")
    public ResponseEntity<Response> getServers(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .status(OK)
                        .statusCode(OK.value())
                        .message("Projects Retrieved")
                        .data(Collections.singletonMap("projects" , projectService.getProjects() ))
                        .build()
        );
    }


    @PostMapping("/save")
    public ResponseEntity<Response> saveProject(@RequestBody @Valid Project project) throws IOException {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .data(Collections.singletonMap("project" , projectService.saveProject(project) ) )
                        .message("Project Information Stored")
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getProject(@PathVariable("id") Long id)  {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .status(OK)
                        .statusCode(OK.value())
                        .data(Collections.singletonMap("project" , projectService.getProjectById(id) ) )
                        .message("Find Project for id : "+ id)
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteProject(@PathVariable("id") Long id)  {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .status(OK)
                        .statusCode(OK.value())
                        .data(Collections.singletonMap("deleted" , projectService.delete(id) ) )
                        .message("Project Deleted id : "+ id)
                        .build()
        );
    }

    @GetMapping(path = "/image/{fileName}", produces = IMAGE_PNG_VALUE)
    public byte[] getImage(@PathVariable("fileName") String fileName) throws IOException {
        System.out.println(System.getProperty("user.home")+"Downloads/images/"+ fileName);
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Downloads/images/"+ fileName));
    }

}
