package com.dusinski.flashcardrestbackend;

import com.dusinski.flashcardrestbackend.services.DictReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class FlashcardRestBackend {

    @Autowired
    private DictReader dictReader;

    public static void main(String[] args) {

        SpringApplication.run(FlashcardRestBackend.class, args);
    }

    @Bean
    InitializingBean sentDb() {
        return ()->{
            dictReader.loadDataFromFileToDb();
        };
    }

}
