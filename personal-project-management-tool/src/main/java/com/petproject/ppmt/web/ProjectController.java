package com.petproject.ppmt.web;

import com.petproject.ppmt.domain.Project;
import com.petproject.ppmt.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/project")
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createNewProject(@RequestBody Project project){
         Project projectRes = projectService.saveOrUpdate(project);
        return new ResponseEntity<>(projectRes, HttpStatus.CREATED);
    }
}
