package com.example.springproject.controllers;

import com.example.springproject.models.User;
import com.example.springproject.models.Vacancy;
import com.example.springproject.services.UserService;
import com.example.springproject.services.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path = "/api/vacancies")
public class VacancyController {
    private final VacancyService vacancyService;

    @Autowired
    public VacancyController(VacancyService vacancyService) {
        this.vacancyService=vacancyService;
    }

    @GetMapping()
    @ResponseBody
    public List<Vacancy> getVacancies() {
        return vacancyService.getVacancies();
    }

}
