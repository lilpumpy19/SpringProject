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
            Vacancy vacancy = new Vacancy("https://st2.depositphotos.com/1000291/7672/i/600/depositphotos" +
                    "_76720771-stock-photo-warehouse-worker-in-front-of.jpg",
                    "грузчик","саратов",20000);
            Vacancy vacancy1 = new Vacancy("https://proforientator.ru/publications/articles/New%20Folder/" +
                    "povar1.jpg",
                    "повар","саратов",30000);
            Vacancy vacancy2 = new Vacancy("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSukz" +
                    "HGNQe0tBdvrZyOTaBGxJD04T8GGaJWKgm-mUA_&s",
                    "разработчик it","саратов",80000);
            Vacancy vacancy3 = new Vacancy("https://uploads.hb.cldmail.ru/geekbrains/public/ckeditor_assets/" +
                    "pictures/7154/retina-1c93319650608e4198837843ff63e27b.jpg",
                    "разработчик it","москва",100000);
            Vacancy vacancy4= new Vacancy("https://276709.selcdn.ru/proektoria/new/professions/2020/03/24/" +
                    "496e05e1aea0a9c4655800e8a7b9ea28/2019-12-07_22-54-49.jpg",
                    "экономист","саратов",66000);
            Vacancy vacancy5 = new Vacancy("https://s1.stc.all.kpcdn.net/putevoditel/projectid_346574/images/" +
                    "tild6137-3962-4162-a534-346433623839__960.jpg",
                    "разработчик it","спб",120000);
            Vacancy vacancy6 = new Vacancy("https://png.pngtree.com/png-clipart/20190619/original/" +
                    "pngtree-community-service-youth-volunteer-college-students-help-png-image_3966124.jpg",
                    "уборщик","саратов",10000);
            repository.saveAll(List.of(vacancy,vacancy1,vacancy2,vacancy4,vacancy5,vacancy6,vacancy3));
        };
    }
}
