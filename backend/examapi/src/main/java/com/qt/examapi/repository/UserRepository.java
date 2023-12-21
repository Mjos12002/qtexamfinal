package com.qt.examapi.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.qt.examapi.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, UUID>{
} 
