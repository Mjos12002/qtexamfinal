package com.qt.examapi.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qt.examapi.dto.DepartmentDTO;
import com.qt.examapi.entity.DepartmentEntity;
import com.qt.examapi.repository.DepartmentRepository;
import com.qt.examapi.response.GenericResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("api")
public class DepartmentController {
    
    @Autowired
    DepartmentRepository departmentRepository;
    
      // Method used to poset the department details
    @CrossOrigin
    @PostMapping(value="/post-department", produces="application/json", consumes="application/json")
    public ResponseEntity<GenericResponse> postDepartment(@RequestBody DepartmentDTO department){
        
        GenericResponse genericResponse;
        ResponseEntity<GenericResponse> responseEntity;
        try{
            UUID uuid = UUID.randomUUID();
            departmentRepository.save(new DepartmentEntity(uuid, department.getName(), 1));
            genericResponse = new GenericResponse("Success", 201, "Saved successully", null);
            responseEntity = ResponseEntity.status(201).body(genericResponse);
        }catch(Exception e){
            genericResponse = new GenericResponse("Error", 500, "Failed to save data ", null);
            responseEntity = ResponseEntity.status(500).body(genericResponse);

        }
        return responseEntity;
    }
    
}
