package com.example.questionnaire.mapper;


import com.example.questionnaire.dto.CustomerCreationDTO;
import com.example.questionnaire.dto.CustomerDTO;
import com.example.questionnaire.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Mapper {

    public CustomerDTO toDTO(Customer customer){
        var dto = new CustomerDTO();
        dto.setName(customer.getName());
        dto.setPoints(customer.getPoints());
        dto.setRole(customer.getRole());
        dto.setCustomerSelectAnswers(customer.getAnswers());
        return dto;
    }

    public Customer toCustomer(CustomerDTO dto){
        var customer = new Customer();
        customer.setName(dto.getName());
        customer.setPoints(dto.getPoints());
        customer.setAnswers(dto.getCustomerSelectAnswers());
        customer.setRole(dto.getRole());
        return customer;
    }

    public Customer createCustomer(CustomerCreationDTO customerCreationDTO){
        var customer = new Customer();
        customer.setName(customerCreationDTO.getName());
        customer.setEmail(customerCreationDTO.getEmail());
        customer.setPoints(0);
        customer.setAnswers(new ArrayList<>());
        customer.setRole(customerCreationDTO.getRole());
        return customer;
    }
}
