package com.example.questionnaire.repository;

import com.example.questionnaire.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {

    List<Questionnaire> findAll();

    @Override
    Optional<Questionnaire> findById(Long aLong);
}
