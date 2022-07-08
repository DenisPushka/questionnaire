package com.example.questionnaire.repository;

import com.example.questionnaire.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
