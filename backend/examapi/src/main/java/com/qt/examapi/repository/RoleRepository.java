package com.qt.examapi.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import com.qt.examapi.entity.RolesEntity;

public interface RoleRepository extends CrudRepository<RolesEntity, UUID>{}
