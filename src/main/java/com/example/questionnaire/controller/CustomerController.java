package com.example.questionnaire.controller;

import com.example.questionnaire.model.Customer;
import com.example.questionnaire.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import static com.example.questionnaire.model.Role.ADMIN;

@Controller
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers(Customer customer) {
        return customer.getRole().equals(ADMIN) ? customerService.readUsers() : new ArrayList<>();
    }

    @PostMapping
    public ResponseEntity addCustomer(Customer customer){
        return customerService.saveUser(customer);
    }

    @PostMapping("/addQuestionnaire")
    public ResponseEntity addQuestionnaire(Customer customer){
        return customerService.addQuestionnaire(customer);
    }

    @GetMapping("/ratingCustomer")
    public Integer ratingCustomer(Customer customer){
        return customerService.ratingUser(customer);
    }

}
