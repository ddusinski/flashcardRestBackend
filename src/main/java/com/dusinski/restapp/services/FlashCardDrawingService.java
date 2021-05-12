package com.dusinski.restapp.services;

import com.dusinski.restapp.model.DictEntity;
import com.dusinski.restapp.model.FlashCardEntity;
import com.dusinski.restapp.repository.DictEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlashCardDrawingService {

    @Autowired
    DictEntityRepository dictEntityRepository;

    private  List<DictEntity> dictEntityList = new ArrayList<>();

    private DictEntity randomFlashcard() {
        int random = (int) (Math.random() * this.dictEntityList.size());
        return this.dictEntityList.remove(random);
    }

    public FlashCardEntity drawFlashcard() {

        dictEntityList=dictEntityRepository.findAll();

        List<DictEntity> randomDictEntities = new ArrayList<>();
        List<String>guessList =  new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            DictEntity dictEntity =randomFlashcard();
            randomDictEntities.add(dictEntity);
            guessList.add(dictEntity.getEnglish());
        }
        //draw one of 4 DictEntities
        int guessId = (int) (Math.random() * randomDictEntities.size());

        return new FlashCardEntity(randomDictEntities.get(guessId).getId(),
                randomDictEntities.get(guessId).getPolish(),
                guessList);

    }
}