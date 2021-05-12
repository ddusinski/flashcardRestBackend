package com.dusinski.restapp.controller;

import com.dusinski.restapp.model.DictEntity;
import com.dusinski.restapp.model.FlashCardEntity;
import com.dusinski.restapp.model.Greeting;
import com.dusinski.restapp.repository.DictEntityRepository;
import com.dusinski.restapp.services.FlashCardDrawingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/api")
public class DictRestController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @Autowired
    DictEntityRepository dictEntityRepository;

    @Autowired
    FlashCardDrawingService flashCardDrawingService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/dict")
    public DictEntity dictEntity(@RequestParam(value="id",defaultValue = "1") long id) {
        return dictEntityRepository.findById(id);
    }

    @GetMapping("/draw")
    public FlashCardEntity drawFlashCard(){
        return flashCardDrawingService.drawFlashcard();
    }


}
