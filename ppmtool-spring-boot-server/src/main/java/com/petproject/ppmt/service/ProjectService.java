package com.petproject.ppmt.service;

import com.petproject.ppmt.domain.Project;
import com.petproject.ppmt.exception.ProjectIdException;
import com.petproject.ppmt.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProjectService {
  private final ProjectRepository projectRepo;

  public Project saveOrUpdate(Project project) {
    project.setIdentifier(project.getIdentifier().toUpperCase());
    try {
      return projectRepo.save(project);
    } catch (Exception ex) {
      throw new ProjectIdException("Project ID: '" + project.getIdentifier() + "' already exits");
    }
  }

  public Project findByIdentifier(String projectId) {
    Optional<Project> project = projectRepo.findByIdentifier(projectId.toUpperCase());
    if (project.isEmpty()) {
      throw new ProjectIdException("Project ID: '" + projectId + "' doesn't exits");
    }
    return project.get();
  }

  public Iterable<Project> findAll() {
    return projectRepo.findAll();
  }

  public void deleteProject(String projectId) {
    Project project = this.findByIdentifier(projectId);
    projectRepo.delete(project);
  }
}
