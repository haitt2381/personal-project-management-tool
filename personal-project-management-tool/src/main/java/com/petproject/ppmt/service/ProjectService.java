package com.petproject.ppmt.service;

import com.petproject.ppmt.domain.Project;
import com.petproject.ppmt.exception.ProjectIdException;
import com.petproject.ppmt.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectService {
    private final ProjectRepository projectRepo;

    public Project saveOrUpdate(Project project){
        project.setIdentifier(project.getIdentifier().toUpperCase());
        try{
            return projectRepo.save(project);
        }catch (Exception ex){
            throw new ProjectIdException("Project ID: '"+project.getIdentifier()+"' already exits");
        }
    }
}
