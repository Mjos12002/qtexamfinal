package com.qt.examapi.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.qt.examapi.entity.ProjectEntity;

public interface ProjectRepository extends CrudRepository<ProjectEntity, UUID>{
    
}
