package com.qt.examapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// A data transfer object for transferring the profile data
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfilesDTO {
    String id, names, phonumber, address;
    int status;
}
