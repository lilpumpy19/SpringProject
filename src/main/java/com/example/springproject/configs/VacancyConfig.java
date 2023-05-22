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
            Vacancy vacancy3 = new Vacancy("разработчик it","москва",100000);
            Vacancy vacancy4= new Vacancy("экономист","саратов",66000);
            Vacancy vacancy5 = new Vacancy("разработчик it","спб",120000);
            Vacancy vacancy6 = new Vacancy("уборщик","саратов",10000);
            repository.saveAll(List.of(vacancy,vacancy1,vacancy2,vacancy4,vacancy5,vacancy6,vacancy3));
        };
    }
}
