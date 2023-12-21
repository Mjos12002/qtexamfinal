package com.qt.examapi.response;

import org.hibernate.mapping.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse {
    
    String status;
    int code;
    String description;
    List data;
    
}
