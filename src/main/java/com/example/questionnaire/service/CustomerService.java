package com.example.questionnaire.service;

import com.example.questionnaire.model.Customer;
import com.example.questionnaire.model.CustomerSelectAnswers;
import com.example.questionnaire.repository.CustomerRepository;
import com.example.questionnaire.repository.CustomerSelectAnswerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerSelectAnswerRepository customerSAnRepository;

    public Customer saveCustomer(Customer customer) {
        return customer.getId() == null && !customerRepository.existsCustomerByEmail(customer.getEmail()) ?
                customerRepository.save(customer) :
                customerRepository.findByEmail(customer.getEmail());
    }

    public Customer addAnswer(Long id, CustomerSelectAnswers customerSelectAnswers) {
        if (customerRepository.findById(id).isPresent()) throw new NullPointerException("нет пользователя!");
        var customer = customerRepository.findById(id).get();
        customerSAnRepository.save(customerSelectAnswers);
        customer.getAnswers().add(customerSelectAnswers);
        return saveCustomer(customer);
    }

    public List<Customer> readCustomer() {
        var sort = Sort.by("Points").ascending();
        return customerRepository.findAll(sort);
    }

    public Integer ratingCustomer(Long id) {
        if (customerRepository.findById(id).isPresent()) throw new NullPointerException("нет пользователя!");
        return customerRepository.findById(id).get().getPoints();
    }

    public Customer updatePoints(Long id, Integer points) {
        if (customerRepository.findById(id).isPresent()) throw new NullPointerException("нет пользователя!");
        var customer = customerRepository.findById(id).get();
        customer.setPoints(points);
        return customerRepository.save(customer);
    }

    public boolean deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        return true;
    }
}
