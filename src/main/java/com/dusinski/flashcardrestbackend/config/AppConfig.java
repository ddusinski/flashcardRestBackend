package com.dusinski.flashcardrestbackend.config;

import com.dusinski.flashcardrestbackend.services.UserSessionDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class AppConfig {

    @Bean
    @SessionScope
    public UserSessionDetail userSessionDetail() {
        return new UserSessionDetail();
    }

}
