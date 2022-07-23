package com.example.questionnaire.controller;

import com.example.questionnaire.model.Question;
import com.example.questionnaire.model.Questionnaire;
import com.example.questionnaire.service.QuestionnaireService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    private final QuestionnaireService questionnaireService;

    @GetMapping("/{id}")
    public ResponseEntity<Questionnaire> getQuestionnaire(@PathVariable Long id) {
        return new ResponseEntity<>(questionnaireService.findQuestionnaireById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Questionnaire>> allQuestionnaires() {
        return new ResponseEntity<>(questionnaireService.allQuestionnaires(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addQuestionnaires(@RequestBody Questionnaire questionnaire) {
        return new ResponseEntity<>(questionnaireService.saveQuestionnaire(questionnaire), HttpStatus.OK);
    }

    @PostMapping("/addQuestion/{id}")
    public ResponseEntity addQuestion(@PathVariable Long id, @RequestBody Question question) {
        if (question.getAnswers().size() < 2)
            return new ResponseEntity<>("Должно быть больше ответов", HttpStatus.NOT_ACCEPTABLE);
        if (!question.getAnswers().contains(question.getTrueAnswer()))
            return new ResponseEntity<>("Нет правильного ответа", HttpStatus.NOT_ACCEPTABLE);

        return new ResponseEntity<>(questionnaireService.addQuestion(id, question), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteQuestionnaire(@PathVariable Long id){
        return questionnaireService.deleteQuestionnaire(id);
    }

    @DeleteMapping("/question/{id}")
    public Boolean deleteCustomer(@PathVariable Long id) {
        return questionnaireService.deleteQuestion(id);
    }
}
