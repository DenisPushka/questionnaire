package com.example.questionnaire.dto;

import com.example.questionnaire.model.Role;
import lombok.Data;

@Data
public class CustomerCreationDTO {
    private String name;
    private String email;
    private Role role;
}
