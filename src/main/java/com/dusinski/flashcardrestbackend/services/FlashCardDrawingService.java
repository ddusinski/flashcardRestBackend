package com.dusinski.flashcardrestbackend.services;

import com.dusinski.flashcardrestbackend.model.DictEntity;
import com.dusinski.flashcardrestbackend.model.FlashCard;
import com.dusinski.flashcardrestbackend.repository.DictEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlashCardDrawingService {

    @Autowired
    DictEntityRepository dictEntityRepository;

    @Autowired
    UserSessionDetail userSessionDetail;

    public FlashCardDrawingService() {
    }

    private DictEntity randomFlashcard(List<DictEntity> list) {
        int random = (int) (Math.random() * list.size());
        return list.remove(random);
    }

    public FlashCard drawFlashcard() {

        List<DictEntity> dictEntityList = dictEntityRepository.findAll();
        dictEntityList.removeAll(userSessionDetail.getAlreadyUsedFlashcards());
        List<DictEntity> randomDictEntities = new ArrayList<>();
        List<String> guessList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            DictEntity chosenDictEntity = randomFlashcard(dictEntityList);
            dictEntityList.remove(chosenDictEntity);
            randomDictEntities.add(chosenDictEntity);
            guessList.add(chosenDictEntity.getEnglish());
        }
        //draw one of 4 DictEntities
        int guessId = (int) (Math.random() * randomDictEntities.size());
        userSessionDetail.addAlreadyUsedFlashcard(randomDictEntities.get(guessId));

        return new FlashCard(randomDictEntities.get(guessId).getId(),
                randomDictEntities.get(guessId).getPolish(),
                guessList);
    }

    public boolean checkFlashcardAnswer(long questionID, String answer) {
        DictEntity dictEntity = dictEntityRepository.findById(questionID);
        return answer.equals(dictEntity.getEnglish());
    }
}
