package com.dusinski.restapp;

import com.dusinski.restapp.model.DictEntity;
import com.dusinski.restapp.repository.DictEntityRepository;
import com.dusinski.restapp.services.DictReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


@SpringBootApplication
public class RestApp {

    @Autowired
    private DictReader dictReader;

    public static void main(String[] args) {

        SpringApplication.run(RestApp.class, args);
    }

    @Bean
    InitializingBean sentDb() {
        return ()->{
            dictReader.loadDataFromFileToDb();
        };
    }

}
