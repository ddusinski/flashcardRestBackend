package com.dusinski.restapp.model;

import java.util.ArrayList;
import java.util.List;

public class FlashCardEntity {
    private final long id;


    private final String originalWord;

    private final List<String> guessOptions=new ArrayList<>();

    public FlashCardEntity(long answerId,String org, List<String>  guessList) {
        originalWord = org;
        this.id=answerId;
        this.guessOptions.addAll(guessList);

    }

    public long getId() {
        return id;
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public List<String> getGuessOptions() {
        return guessOptions;
    }

}
