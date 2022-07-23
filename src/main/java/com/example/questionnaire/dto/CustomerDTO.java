package com.example.questionnaire.dto;

import com.example.questionnaire.model.CustomerSelectAnswers;
import com.example.questionnaire.model.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerDTO {
    private String name;
    private Role role;
    private List<CustomerSelectAnswers> customerSelectAnswers = new ArrayList<>();
    private Integer points;
}
