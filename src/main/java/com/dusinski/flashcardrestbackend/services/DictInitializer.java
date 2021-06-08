package com.dusinski.flashcardrestbackend.services;

import com.dusinski.flashcardrestbackend.model.DictEntity;
import com.dusinski.flashcardrestbackend.repository.DictEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

@Service
public class DictInitializer {

    @Value("classpath:eng.txt")
    Resource dictFile;

    @Autowired
    private DictEntityRepository dictEntityRepository;

    @PostConstruct
    public void loadDataFromFileToDb() {
        ArrayList<DictEntity> input = new ArrayList<>();
        Long id = 0L;
        try {
            InputStream inputFile = dictFile.getInputStream();
            Scanner reader = new Scanner(inputFile);
            while (reader.hasNextLine()) {
                id++;
                String currentLine = reader.nextLine();
                if (currentLine.contains("\t")) {
                    dictEntityRepository.save(new DictEntity(id, currentLine.split("\t+")[0].replaceFirst("\\s++$", ""),
                            currentLine.split("\t+")[1].replaceFirst("\\s++$", "")));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
