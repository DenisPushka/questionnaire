package com.example.questionnaire.controller;

import com.example.questionnaire.model.Customer;
import com.example.questionnaire.model.Questionnaire;
import com.example.questionnaire.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/updatePoint/{id}")
    public ResponseEntity<Customer> updatePoint(@PathVariable Long id, @RequestBody Integer points) {
        return customerService.updatePoints(id, points);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
//        return customer.getRole().equals(ADMIN) ? customerService.readUsers() : new ArrayList<>();
        return customerService.readCustomer();
    }

    @GetMapping("/{id}")
    public Customer getCustomers(@PathVariable Long id) {
        return customerService.findFirstById(id);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PostMapping("/addQuestionnaire/{id}")
    public Customer addQuestionnaire(@PathVariable Long id, @RequestBody Questionnaire questionnaire) {
        return customerService.addQuestionnaire(id, questionnaire);
    }

    @GetMapping("/ratingCustomer/{id}")
    public Integer ratingCustomer(@PathVariable Long id) {
        return customerService.ratingCustomer(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }
}
