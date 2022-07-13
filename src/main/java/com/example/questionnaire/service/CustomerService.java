package com.example.questionnaire.service;

import com.example.questionnaire.model.Customer;
import com.example.questionnaire.model.Questionnaire;
import com.example.questionnaire.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customer.getId() == null && !customerRepository.existsCustomerByEmail(customer.getEmail()) ?
                customerRepository.save(customer) :
                customerRepository.findByEmail(customer.getEmail());
    }

    public Customer addQuestionnaire(Long id, Questionnaire questionnaire) {
        var customer = findFirstById(id);
        customer.getQuestionnaires().add(questionnaire);
        return saveCustomer(customer);
    }

    public ResponseEntity<List<Customer>> readCustomer() {
        var sort = Sort.by("Points").ascending();
        var customers = new ArrayList<>(customerRepository.findAll(sort));

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    public Customer findFirstById(Long id) {
        return customerRepository.findFirstById(id);
    }

    public Integer ratingCustomer(Long id) {
        return findFirstById(id).getPoints();
    }

    public ResponseEntity<Customer> updatePoints(Long id, Integer points) {
        var customer = findFirstById(id);
        customer.setPoints(points);
        return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.OK);
    }

    public boolean deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        return true;
    }
}
