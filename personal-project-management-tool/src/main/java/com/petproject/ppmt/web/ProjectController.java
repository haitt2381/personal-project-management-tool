package com.petproject.ppmt.web;

import com.petproject.ppmt.domain.Project;
import com.petproject.ppmt.service.MapValidationErrorService;
import com.petproject.ppmt.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/project")
public class ProjectController {
    private final ProjectService projectService;
    private final MapValidationErrorService mapErrorService;

    @PostMapping
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){

        ResponseEntity<?> responseError = mapErrorService.bindingResultToMapError(result);
        if(responseError != null) return responseError;

         Project projectRes = projectService.saveOrUpdate(project);
        return new ResponseEntity<>(projectRes, HttpStatus.CREATED);
    }
}
