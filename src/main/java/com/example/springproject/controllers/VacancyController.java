package com.example.springproject.controllers;

import com.example.springproject.models.Vacancy;
import com.example.springproject.services.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/vacancies")
public class VacancyController {
    private VacancyService vacancyService;

    @Autowired
    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping()
    public List<Vacancy> getVacancies(
            @RequestParam(value = "jobTitle", required = false) String jobTitle,
            @RequestParam(value = "location", required = false) String location) {
        if (jobTitle != null && location != null) {
            return vacancyService.getVacanciesByJobTitleAndLocation(jobTitle, location);
        } else if (jobTitle != null) {
            return vacancyService.getVacanciesByJobTitle(jobTitle);
        } else if (location != null) {
            return vacancyService.getVacanciesByLocation(location);
        } else {
            return vacancyService.getVacancies();
        }
    }
}