package com.example.questionnaire.repository;

import com.example.questionnaire.model.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);

    Customer findFirstById(Long id);

    List<Customer> findAll();

    List<Customer> findAll(Sort sort);

    boolean existsCustomerByEmail(String email);
}
