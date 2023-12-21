package com.qt.examapi.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Data transfer object used to transfer users data
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    UUID uuid;
    String name;
    String description;
}
