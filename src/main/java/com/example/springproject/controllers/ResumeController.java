package com.example.springproject.controllers;

import com.example.springproject.models.Resume;
import com.example.springproject.models.ResumeCreateRequest;
import com.example.springproject.models.User;
import com.example.springproject.services.ResumeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    // Внедрение сервиса ResumeService через конструктор

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/get")
    public ResponseEntity<Resume> getUserResume(Authentication authentication) {
        // Получаем аутентифицированного пользователя из контекста безопасности
        User user = (User) authentication.getPrincipal();

        // Получаем резюме пользователя по его идентификатору
        Resume resume = resumeService.getResumeByUserId(user.getId());

        if (resume != null) {
            // Резюме найдено, возвращаем успешный ответ и резюме пользователя
            return ResponseEntity.ok(resume);
        } else {
            // Резюме не найдено, возвращаем ответ с кодом 404
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resume> createResume(@RequestBody ResumeCreateRequest request) {
        // Получите текущего пользователя из вашей системы аутентификации
        User currentUser = UserController.getCurrentUser();

        // Создайте объект Resume и установите значения полей из запроса
        Resume resume = new Resume();
        resume.setUser(currentUser);
        resume.setName(request.getName());
        resume.setSurname(request.getSurname());
        resume.setPatronymic(request.getPatronymic());
        resume.setDate(request.getDate());
        resume.setEmail(request.getEmail());
        resume.setMyPhoto(request.getMyPhoto());
        resume.setAboutMe(request.getAboutMe());

        // Сохраните объект Resume в базе данных
        Resume savedResume = resumeService.save(resume);

        return ResponseEntity.ok(savedResume);
    }



}












