package com.example.questionnaire.repository;

import com.example.questionnaire.model.Questionnaire;
import org.springframework.data.repository.CrudRepository;

public interface QuestionnaireRepository extends CrudRepository<Questionnaire, Long> {
}
