package com.example.questionnaire.service;

import com.example.questionnaire.model.Question;
import com.example.questionnaire.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public ResponseEntity addQuestion(Question question){
        return ResponseEntity.ok(questionRepository.save(question));
    }
}
