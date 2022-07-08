package com.example.questionnaire.service;

import com.example.questionnaire.exeption.EntityNotFound;
import com.example.questionnaire.model.Question;
import com.example.questionnaire.model.Questionnaire;
import com.example.questionnaire.repository.QuestionRepository;
import com.example.questionnaire.repository.QuestionnaireRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionnaireService {
    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionRepository questionRepository;

    public ResponseEntity saveQuestionnaire(Questionnaire questionnaire){
        return ResponseEntity.ok(questionnaireRepository.save(questionnaire));
    }

    public Questionnaire findQuestionnaireById(Long id) {
        return questionnaireRepository.findById(id).orElseThrow(EntityNotFound::new);
    }

    public ResponseEntity addQuestion(Long id, Question question){
        question = questionRepository.save(question);
        var questionnaire = findQuestionnaireById(id);
        questionnaire.getQuestions().add(question);
        return saveQuestionnaire(questionnaire);
    }

    public List<Questionnaire> allQuestionnaires(){
        return (List<Questionnaire>) questionnaireRepository.findAll();
    }
}
