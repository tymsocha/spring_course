package com.myprojects.kursspring.config;

import com.myprojects.kursspring.repositories.DBKnightRepository;
import com.myprojects.kursspring.repositories.InMemoryKnightRepository;
import com.myprojects.kursspring.repositories.KnightRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MainConfig {

    @Bean(name = "inMemoryKnightRepository")
    @Profile("dev")
    public KnightRepository createInMemoryRepo() {
        return new InMemoryKnightRepository();
    }

    @Bean(name = "DBKnightRepository")
    @Profile("prod")
    public KnightRepository createDBRepo() {
        return new DBKnightRepository();
    }
}
