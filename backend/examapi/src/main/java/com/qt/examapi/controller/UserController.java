package com.qt.examapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.usertype.UserVersionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qt.examapi.dto.ProfilesDTO;
import com.qt.examapi.dto.UsersDTO;
import com.qt.examapi.entity.UserEntity;
import com.qt.examapi.repository.UserRepository;
import com.qt.examapi.response.GenericResponse;

import lombok.extern.log4j.Log4j2;

// Controller used for managing user activities
@Log4j2
@RestController
@RequestMapping("api")
public class UserController {

    //Autowiring the repository for user entity CRUD
    @Autowired
    UserRepository userRepository;    

    // Method used to post the users details 
    @CrossOrigin
    @PostMapping(value="/post-user", produces="application/json", consumes="application/json")
    public ResponseEntity<GenericResponse> postUser(@RequestBody UsersDTO users){
        GenericResponse genericResponse;
        ResponseEntity<GenericResponse> responseEntity;

        try{
            UUID uuid = UUID.randomUUID();
            userRepository.save(new UserEntity(uuid, users.getEmail(), users.getPassword(), 1, users.getProfileid(), users.getDepartmentid()));
            genericResponse = new GenericResponse("Success", 201, "Saved successfully", null);
            responseEntity = ResponseEntity.status(201).body(genericResponse);
        }catch(Exception e){
            genericResponse = new GenericResponse("Failed", 500, "Saved successfully", null);
            responseEntity = ResponseEntity.status(500).body(genericResponse);
        }
        return responseEntity;
    }

    // Method used to get user base on the user ID
    @CrossOrigin
    @GetMapping(value="/get-user/{id}", produces="application/json", consumes="application/json")
    public ResponseEntity<Optional<UserEntity>> getUser(@PathVariable String id){
        Optional<UserEntity> users = userRepository.findById(UUID.fromString(id));
        return ResponseEntity.status(201).body(users);
    }

    // Method used to get all hte users
    @CrossOrigin
    @GetMapping(value="/get-users", produces="application/json", consumes="application/json")
    public ResponseEntity<Iterable<UserEntity>> getAllUser(){
        Iterable<UserEntity> users = userRepository.findAll();
        return ResponseEntity.status(201).body(users);
    }

    // Method used to edit the user
    @CrossOrigin
    @PostMapping(value="/edit-user/{id}", produces="application/json", consumes="application/json")
    public GenericResponse editUser(@PathVariable String id, @RequestBody ProfilesDTO profiles){
        return null;
    }

}
