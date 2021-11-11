package com.petproject.ppmt.web;

import com.petproject.ppmt.domain.Project;
import com.petproject.ppmt.service.MapValidationErrorService;
import com.petproject.ppmt.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/project")
public class ProjectController {
  private final ProjectService projectService;
  private final MapValidationErrorService mapErrorService;

  @PostMapping
  public ResponseEntity<?> createNewProject(
      @Valid @RequestBody Project project, BindingResult result) {

    ResponseEntity<?> responseError = mapErrorService.bindingResultToMapError(result);
    if (responseError != null) return responseError;

    Project projectRes = projectService.saveOrUpdate(project);
    return new ResponseEntity<>(projectRes, HttpStatus.CREATED);
  }

  @GetMapping("{projectId}")
  public ResponseEntity<?> findByIdentifierProject(@PathVariable String projectId) {
    return new ResponseEntity<>(projectService.findByIdentifier(projectId), HttpStatus.OK);
  }

  @GetMapping("/all")
  public Iterable<Project> getAllProject() {
    return projectService.findAll();
  }

  @DeleteMapping("{projectId}")
  public ResponseEntity<String> deleteProjectByIdentity(@PathVariable String projectId) {
    projectService.deleteProject(projectId);
    return new ResponseEntity<>("Project with ID: '" + projectId + "' was deleted", HttpStatus.OK);
  }
}
