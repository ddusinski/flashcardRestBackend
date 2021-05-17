package com.dusinski.flashcardrestbackend.services;

import com.dusinski.flashcardrestbackend.model.DictEntity;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.ArrayList;
import java.util.List;

public class UserSessionDetail {
    private final List<DictEntity> alreadyUsedFlashcardsIds = new ArrayList<>();

    public List<DictEntity> getAlreadyUsedFlashcards() {
//        System.out.println("current session id: " + RequestContextHolder.getRequestAttributes().getSessionId());
        return alreadyUsedFlashcardsIds;
    }

    public void addAlreadyUsedFlashcard(DictEntity dictEntity) {
        this.alreadyUsedFlashcardsIds.add(dictEntity);
    }

}
