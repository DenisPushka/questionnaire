package com.example.questionnaire.repository;

import com.example.questionnaire.model.Answers;
import com.example.questionnaire.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository  extends JpaRepository<Answers, Long> {
}
