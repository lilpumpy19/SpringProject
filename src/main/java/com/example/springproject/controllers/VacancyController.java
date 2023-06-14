package com.example.springproject.controllers;

import com.example.springproject.models.*;
import com.example.springproject.services.UserService;
import com.example.springproject.services.VacancyService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/vacancies")
public class VacancyController {

    private VacancyService vacancyService;

    private UserService userService;

    @Autowired
    public VacancyController(VacancyService vacancyService,UserService userService) {
        this.vacancyService = vacancyService;
        this.userService = userService;
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

    @GetMapping("/myVacancies")
    public List<Vacancy> getVacanciesByUserId(@AuthenticationPrincipal UserDetails userDetails) {
        User currentUser = userService.getUserByUsername(userDetails.getUsername());
        return vacancyService.getVacanciesByUserId(currentUser.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vacancy> getVacancyById(@PathVariable Long id) {
        Vacancy vacancy = vacancyService.getVacancyById(id);
        if (vacancy != null) {
            return ResponseEntity.ok(vacancy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vacancy> createResume(@RequestBody VacancyRequest vacancyRequest) {
        // Получите текущего пользователя из вашей системы аутентификации
        User currentUser = UserController.getCurrentUser();

        // Создайте объект Resume и установите значения полей из запроса
        Vacancy vacancy = new Vacancy();
        vacancy.setJobTitle(vacancyRequest.getJobTitle());
        vacancy.setLocation(vacancyRequest.getLocation());
        vacancy.setDescription(vacancyRequest.getDescription());
        vacancy.setImg(vacancyRequest.getImg());
        vacancy.setSalary(vacancyRequest.getSalary());
        vacancy.setUser(currentUser);
        // Сохраните объект Resume в базе данных
        Vacancy savedVacancy=vacancyService.addNewVacancy(vacancy);

        return ResponseEntity.ok(savedVacancy);
    }

    @PostMapping("/{vacancyId}/apply")
    public ResponseEntity<String> applyToVacancy(@PathVariable Long vacancyId, @AuthenticationPrincipal UserDetails userDetails) {
        Vacancy vacancy = vacancyService.getVacancyById(vacancyId);

        if (vacancy == null) {
            return ResponseEntity.notFound().build();
        }

        // Получение текущего пользователя
        User currentUser = userService.getUserByUsername(userDetails.getUsername());

        // Создание объекта резюме
        Resume resume = currentUser.getResume();

        // Заполните остальные поля резюме, используя данные из объекта User или запроса

        vacancy.getApplicants().add(resume);
        vacancyService.addNewVacancy(vacancy);

        return ResponseEntity.ok("Резюме успешно добавлено");
    }

}
