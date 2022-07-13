package com.example.questionnaire.service;

import com.example.questionnaire.model.Question;
import com.example.questionnaire.model.Questionnaire;
import com.example.questionnaire.repository.QuestionRepository;
import com.example.questionnaire.repository.QuestionnaireRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class QuestionnaireService {
    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionRepository questionRepository;

    public ResponseEntity saveQuestionnaire(Questionnaire questionnaire){
        return ResponseEntity.ok(questionnaireRepository.save(questionnaire));
    }

    public ResponseEntity<Questionnaire> findQuestionnaireById(Long id) {
        return new ResponseEntity<>(questionnaireRepository.findFirstById(id), HttpStatus.OK);
    }

    public ResponseEntity addQuestion(Long id, Question question){
        question = questionRepository.save(question);
        var questionnaire = findQuestionnaireById(id);
        questionnaire.getBody().getQuestions().add(question);
        return saveQuestionnaire(questionnaire.getBody());
    }

    public ResponseEntity<List<Questionnaire>> allQuestionnaires(){
        var questionnaires = new ArrayList<Questionnaire>();
        questionnaireRepository.findAll().forEach(questionnaires::add);

        return new ResponseEntity<>(questionnaires, HttpStatus.OK);
    }
}
