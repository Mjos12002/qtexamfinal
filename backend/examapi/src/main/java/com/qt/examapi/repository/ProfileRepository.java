package com.qt.examapi.repository;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import com.qt.examapi.entity.ProfileEntity;

// Repository used to manage CRUD operation of the Profile table
public interface ProfileRepository extends CrudRepository<ProfileEntity, UUID>{
}
