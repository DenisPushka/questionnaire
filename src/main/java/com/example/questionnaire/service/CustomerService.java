package com.example.questionnaire.service;

import com.example.questionnaire.model.Questionnaire;
import com.example.questionnaire.model.Customer;
import com.example.questionnaire.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public ResponseEntity saveUser(Customer customer){
        return ResponseEntity.ok(customerRepository.save(customer));
    }

    public ResponseEntity addQuestionnaire(Customer customer){
        customer.getQuestionnaires().add(new Questionnaire());
        return saveUser(customer);
    }

    public List<Customer> readUsers(){
        return (List<Customer>) customerRepository.findAll();
    }

    public Integer ratingUser(Customer customer){
        return 0;
    }
}
