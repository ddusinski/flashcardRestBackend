package com.dusinski.flashcardrestbackend.controller;

import com.dusinski.flashcardrestbackend.model.DictEntity;
import com.dusinski.flashcardrestbackend.repository.DictEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dict")
public class DictEntityController {

    @Autowired
    private DictEntityRepository dictEntityRepository;

    @GetMapping("/get/{id}")
    public DictEntity getDictEntity(@PathVariable long id) {
        return dictEntityRepository.findById(id);
    }

}
