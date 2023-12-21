package com.qt.examapi.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// A data transfer object used to transfer the department details
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    String id, name;
    int status;
}
