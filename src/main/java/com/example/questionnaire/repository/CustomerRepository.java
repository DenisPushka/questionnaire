package com.example.questionnaire.repository;

import com.example.questionnaire.model.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);

    boolean existsCustomerByName(String name);

    @Override
    Optional<Customer> findById(Long aLong);

    List<Customer> findAll();

    List<Customer> findAll(Sort sort);

    boolean existsCustomerByEmail(String email);
}
