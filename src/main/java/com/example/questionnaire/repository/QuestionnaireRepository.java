package com.example.questionnaire.repository;

import com.example.questionnaire.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {

    List<Questionnaire> findAll();

    Questionnaire findFirstById(Long id);
}
