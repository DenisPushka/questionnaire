package com.example.questionnaire.service;

import com.example.questionnaire.model.Question;
import com.example.questionnaire.model.Questionnaire;
import com.example.questionnaire.repository.QuestionRepository;
import com.example.questionnaire.repository.QuestionnaireRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class QuestionnaireService {
    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionRepository questionRepository;

    public Questionnaire saveQuestionnaire(Questionnaire questionnaire) {
        return questionnaireRepository.save(questionnaire);
    }

    public Questionnaire findQuestionnaireById(Long id) {
        if (questionnaireRepository.findById(id).isPresent()) throw new NullPointerException("нет анкеты!");
        return questionnaireRepository.findById(id).get();
    }

    public Questionnaire addQuestion(Long id, Question question) {
        question = questionRepository.save(question);
        var questionnaire = findQuestionnaireById(id);
        Objects.requireNonNull(questionnaire).getQuestions().add(question);
        return saveQuestionnaire(questionnaire);
    }

    public List<Questionnaire> allQuestionnaires() {
        return questionnaireRepository.findAll();
    }

    public boolean deleteQuestionnaire(Long id) {
        var questionnaire = findQuestionnaireById(id);
        for (var q : questionnaire.getQuestions()) {
            q.setAnswers(new ArrayList<>());
            questionRepository.deleteById(q.getId());
        }

        questionnaire.setQuestions(new ArrayList<>());
        questionnaireRepository.save(questionnaire);
//        var customer = customerRepository.findFirstById(10L);
//        customer.setQuestionnaires(new ArrayList<>());
//        customerRepository.save(customer);
        questionnaireRepository.deleteById(id);
        return true;
    }

    public boolean deleteQuestion(Long id) {
        questionRepository.deleteById(id);
        return true;
    }
}
