package com.qt.examapi.dto;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Data transfer object used to transfer users data
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {
    String email, password;
    UUID profileid, departmentid;
    int status;
}
