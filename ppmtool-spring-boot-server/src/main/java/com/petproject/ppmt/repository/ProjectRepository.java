package com.petproject.ppmt.repository;

import com.petproject.ppmt.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

  @Override
  Iterable<Project> findAllById(Iterable<Long> longs);

  Optional<Project> findByIdentifier(String identifier);
}
