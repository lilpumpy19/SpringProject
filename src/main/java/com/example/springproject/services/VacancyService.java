package com.example.springproject.services;

import com.example.springproject.models.User;
import com.example.springproject.models.Vacancy;
import com.example.springproject.repositories.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyService {
    private VacancyRepository vacancyRepository;

    @Autowired
    public VacancyService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    public List<Vacancy> getVacancies() {
        return vacancyRepository.findAll();
    }

    public List<Vacancy> getVacanciesByLocation(String location) {
        return vacancyRepository.findByLocation(location);
    }

    public List<Vacancy> getVacanciesByJobTitle(String jobTitle) {
        return vacancyRepository.findByJobTitle(jobTitle);
    }

    public List<Vacancy> getVacanciesByJobTitleAndLocation(String jobTitle, String location) {
        return vacancyRepository.findByJobTitleAndLocation(jobTitle, location);
    }

    public void addNewVacancy(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }
}