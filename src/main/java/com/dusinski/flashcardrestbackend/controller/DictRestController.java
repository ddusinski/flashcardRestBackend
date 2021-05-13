package com.dusinski.flashcardrestbackend.controller;

import com.dusinski.flashcardrestbackend.model.DictEntity;
import com.dusinski.flashcardrestbackend.model.FlashCardEntity;
import com.dusinski.flashcardrestbackend.model.Greeting;
import com.dusinski.flashcardrestbackend.repository.DictEntityRepository;
import com.dusinski.flashcardrestbackend.services.FlashCardDrawingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/api")
public class DictRestController {

    @Autowired
    DictEntityRepository dictEntityRepository;

    @Autowired
    FlashCardDrawingService flashCardDrawingService;

    @GetMapping("/dict")
    public DictEntity dictEntity(@RequestParam(value="id",defaultValue = "1") long id) {
        return dictEntityRepository.findById(id);
    }

    @GetMapping("/draw")
    public FlashCardEntity drawFlashCard(){
        return flashCardDrawingService.drawFlashcard();
    }

    @GetMapping("/answer")
    public boolean checkAnswer(@RequestParam(value="questionId") long questionId, @RequestParam(value="flashcardAnswer") String flashcardAnswer){
        return flashCardDrawingService.checkFlashcardAnswer(questionId, flashcardAnswer);
    }


}
