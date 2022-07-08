package com.example.questionnaire.controller;

import com.example.questionnaire.model.Question;
import com.example.questionnaire.model.Questionnaire;
import com.example.questionnaire.service.QuestionnaireService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    private final QuestionnaireService questionnaireService;

    @GetMapping
    public List<Questionnaire> allQuestionnaires() {
        return questionnaireService.allQuestionnaires();
    }

    @PostMapping
    public ResponseEntity addQuestionnaires(Questionnaire questionnaire){
        return questionnaireService.saveQuestionnaire(questionnaire);
    }

    @PostMapping("/addQuestion/{id}")
    public ResponseEntity addQuestion(@PathVariable Long id, Question question) {
        return questionnaireService.addQuestion(id, question);
    }
}
