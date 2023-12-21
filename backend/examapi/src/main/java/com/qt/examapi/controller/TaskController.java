package com.qt.examapi.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qt.examapi.dto.TaskDTO;
import com.qt.examapi.response.GenericResponse;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Log4j2
@RestController
@RequestMapping("api")
public class TaskController {

    @GetMapping("/get-tasks")
    public GenericResponse getAllTasks() {
        return null;
    }

    @GetMapping(value = "/get-task/{id}", produces = "application/json")
    public GenericResponse getMethodName(@PathVariable String id) {
        return null;
    }

    @DeleteMapping(value = "/delete-task/{id}", produces = "application/json")
    public GenericResponse deleteTask(@PathVariable String id){
        return null;
    }

    @PostMapping("/add-task")
    public GenericResponse postMethodName(@RequestBody TaskDTO taskDTO) {
        //TODO: process POST request
        
        return null;
    }
    
    
}
