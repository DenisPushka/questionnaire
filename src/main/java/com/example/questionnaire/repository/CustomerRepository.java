package com.example.questionnaire.repository;

import com.example.questionnaire.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByEmail(String email);

    boolean existsCustomerByEmail(String email);
}
