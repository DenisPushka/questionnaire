package com.example.questionnaire.repository;

import com.example.questionnaire.model.Customer;
import com.example.questionnaire.model.CustomerSelectAnswers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerSelectAnswerRepository  extends JpaRepository<CustomerSelectAnswers, Long> {
}
