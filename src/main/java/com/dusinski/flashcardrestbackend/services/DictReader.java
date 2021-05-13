package com.dusinski.flashcardrestbackend.services;

import com.dusinski.flashcardrestbackend.model.DictEntity;
import com.dusinski.flashcardrestbackend.repository.DictEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@Service
public class DictReader {

    @Autowired
    DictEntityRepository dictEntityRepository;

    private static final String dictName = "eng.txt";

    public void loadDataFromFileToDb() {
        ArrayList<DictEntity> input = new ArrayList<>();
        int id = 0;
        try {

            File inputFile = new File(this.getClass().getClassLoader().getResource(dictName).getFile());
            Scanner reader = new Scanner(inputFile);
            while (reader.hasNextLine()) {
                id++;
                String currentLine = reader.nextLine();
                if (currentLine.contains("\t")) {
                    dictEntityRepository.save(new DictEntity(id, currentLine.split("\t+")[0], currentLine.split("\t+")[1]));
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
