package com.qt.examapi.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qt.examapi.dto.ProjectDTO;
import com.qt.examapi.entity.ProfileEntity;
import com.qt.examapi.entity.ProjectEntity;
import com.qt.examapi.repository.ProjectRepository;
import com.qt.examapi.response.GenericResponse;

import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Log4j2
@RestController
@RequestMapping("api")
public class ProjectController {

    // Autowiring the project repository
    @Autowired
    ProjectRepository projectRepository;

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/post-projects", produces = "application/json")
    public ResponseEntity<GenericResponse> getProjects(@RequestBody ProjectDTO projectDTO) {
        GenericResponse genericResponse;
        ResponseEntity<GenericResponse> responseEntity;
        try{
            UUID uuid = UUID.randomUUID();
            projectRepository.save(new ProjectEntity(uuid, projectDTO.getName(), projectDTO.getDescription()));
            genericResponse = new GenericResponse("Success", 201, "Done successfully", null);
            responseEntity = ResponseEntity.status(201).body(genericResponse);
        }catch(Exception e) {
            genericResponse = new GenericResponse("Failed", 500, "Failed to execute", null);
            responseEntity = ResponseEntity.status(500).body(genericResponse);
        }
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value="/get-projects")
    public ResponseEntity<Iterable<ProjectEntity>> getAllProjects(){
        Iterable<ProjectEntity> users = projectRepository.findAll();
        return ResponseEntity.status(201).body(users);
    }
    
}
