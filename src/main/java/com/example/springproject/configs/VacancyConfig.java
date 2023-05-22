package com.example.springproject.configs;

import com.example.springproject.models.Vacancy;
import com.example.springproject.repositories.VacancyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class VacancyConfig {
    @Bean
    CommandLineRunner commandLineRunner1(VacancyRepository repository){
        return args -> {
            Vacancy vacancy = new Vacancy("грузчик","саратов",20000);
            Vacancy vacancy1 = new Vacancy("повар","саратов",30000);
            Vacancy vacancy2 = new Vacancy("разработчик it","саратов",80000);
            repository.saveAll(List.of(vacancy,vacancy1,vacancy2));
        };
    }
}
