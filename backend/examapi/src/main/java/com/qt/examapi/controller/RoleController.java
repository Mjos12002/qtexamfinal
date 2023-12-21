package com.qt.examapi.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qt.examapi.dto.RolesDTO;
import com.qt.examapi.entity.RolesEntity;
import com.qt.examapi.repository.RoleRepository;
import com.qt.examapi.response.GenericResponse;

import lombok.extern.log4j.Log4j2;

// Controller used for managing user activities
@Log4j2
@RestController
@RequestMapping("api")
public class RoleController {

    // Autowiring the role repository
    @Autowired
    RoleRepository roleRepository;

    // Method used to post roles
    @CrossOrigin
    @PostMapping(value="/post-role", produces="application/json", consumes="application/json")
    public ResponseEntity<GenericResponse> postRoles(@RequestBody RolesDTO roles){

        ResponseEntity<GenericResponse> responseEntity;
        GenericResponse genericResponse;
        try{
            UUID uuid = UUID.randomUUID();
            roleRepository.save(new RolesEntity(uuid, roles.getName(), 1));
            genericResponse = new GenericResponse("Success", 201, "Saved successfully", null);
            responseEntity = ResponseEntity.status(201).body(genericResponse);
        }catch(Exception e) {
            genericResponse = new GenericResponse("Failure", 500, "Operation aborted", null);
            responseEntity = ResponseEntity.status(500).body(genericResponse);
        }
        return responseEntity;
    }
    
}
