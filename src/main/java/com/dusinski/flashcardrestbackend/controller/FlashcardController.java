package com.dusinski.flashcardrestbackend.controller;

import com.dusinski.flashcardrestbackend.model.FlashCard;
import com.dusinski.flashcardrestbackend.services.FlashCardDrawingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flashcard")
public class FlashcardController {

    @Autowired
    private FlashCardDrawingService flashCardDrawingService;

    @GetMapping("/get")
    public FlashCard getFlashCard() {
        return flashCardDrawingService.drawFlashcard();
    }

    @GetMapping("/answer")
    public boolean checkAnswer(@RequestParam(value = "questionId") long questionId, @RequestParam(value = "flashcardAnswer") String flashcardAnswer) {
        return flashCardDrawingService.checkFlashcardAnswer(questionId, flashcardAnswer);
    }

}
