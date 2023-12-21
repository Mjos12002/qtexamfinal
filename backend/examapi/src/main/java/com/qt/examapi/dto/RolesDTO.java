package com.qt.examapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// A data transfer object used to transfer role data
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolesDTO {
    
    String id, name;
    int status;

}
