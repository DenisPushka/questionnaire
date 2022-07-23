package com.example.questionnaire.controller;

import com.example.questionnaire.dto.CustomerCreationDTO;
import com.example.questionnaire.dto.CustomerDTO;
import com.example.questionnaire.mapper.Mapper;
import com.example.questionnaire.model.CustomerSelectAnswers;
import com.example.questionnaire.repository.CustomerRepository;
import com.example.questionnaire.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private final Mapper mapper;

    @PostMapping("/updatePoint/{id}")
    public ResponseEntity<CustomerDTO> updatePoint(@PathVariable Long id, @RequestBody Integer points) {
        var dto = mapper.toDTO(customerService.updatePoints(id, points));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getCustomers() {
        var customersDTO = customerService.readCustomer()
                .stream()
                .map(mapper::toDTO)
                .collect(toList());

        return new ResponseEntity<>(customersDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerCreationDTO customerDTO) {
        if (customerRepository.existsCustomerByName(customerDTO.getName()))
            return new ResponseEntity("Пользователь с таким именем уже существует", HttpStatus.NOT_ACCEPTABLE);
        var customer = mapper.createCustomer(customerDTO);
        var dto = mapper.toDTO(customerService.saveCustomer(customer));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/addAnswer")
    public ResponseEntity<CustomerDTO> addAnswer(@RequestBody CustomerSelectAnswers customerSelectAnswers) {
        if (customerRepository.findById(customerSelectAnswers.getId()).isEmpty())
            return new ResponseEntity("Нет пользователя!", HttpStatus.NOT_ACCEPTABLE);
        var dto = mapper.toDTO(customerService.addAnswer(customerSelectAnswers));

        return new ResponseEntity<>(dto, HttpStatus.OK);
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
