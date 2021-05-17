package com.dusinski.flashcardrestbackend.model;

import java.util.ArrayList;
import java.util.List;

public class FlashCard {
    private final Long id;
    private final String originalWord;
    private final List<String> guessOptions = new ArrayList<>();

    public FlashCard(Long answerId, String org, List<String> guessList) {
        originalWord = org;
        this.id = answerId;
        this.guessOptions.addAll(guessList);

    }

    public Long getId() {
        return id;
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public List<String> getGuessOptions() {
        return guessOptions;
    }

}
