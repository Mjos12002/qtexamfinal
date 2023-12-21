package com.qt.examapi.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qt.examapi.dto.ProfilesDTO;
import com.qt.examapi.entity.ProfileEntity;
import com.qt.examapi.entity.UserEntity;
import com.qt.examapi.repository.ProfileRepository;
import com.qt.examapi.response.GenericResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("api")
public class ProfileController {
    
    //autowiring the profile repository
    @Autowired
    ProfileRepository profileRepository;

    // Method used to post profiles
    @CrossOrigin
    @PostMapping(value="/post-profile", produces="application/json", consumes="application/json")
    public ResponseEntity<GenericResponse> postUser(@RequestBody ProfilesDTO profile){
        GenericResponse genericResponse;
        ResponseEntity<GenericResponse> responseEntity;
        try{
            UUID uuid = UUID.randomUUID();
            profileRepository.save(new ProfileEntity(uuid, profile.getNames(), profile.getPhonumber(), 1, profile.getAddress()));
            genericResponse = new GenericResponse("Success", 201, "Information saved successfully", null);
            responseEntity = ResponseEntity.status(201).body(genericResponse);
        }catch(Exception ex) {
            genericResponse = new GenericResponse("Failed", 500, "Operation failed", null);
            responseEntity = ResponseEntity.status(500).body(genericResponse);
        }
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value="/get-profiles")
    public ResponseEntity<Iterable<ProfileEntity>> getAllProfiles(){
        Iterable<ProfileEntity> users = profileRepository.findAll();
        return ResponseEntity.status(201).body(users);
    }



}
