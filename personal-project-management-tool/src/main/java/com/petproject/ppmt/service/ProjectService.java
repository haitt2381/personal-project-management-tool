package com.petproject.ppmt.service;

import com.petproject.ppmt.domain.Project;
import com.petproject.ppmt.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectService {
    private final ProjectRepository projectRepo;

    public Project saveOrUpdate(Project project){

        return projectRepo.save(project);
    }
}
