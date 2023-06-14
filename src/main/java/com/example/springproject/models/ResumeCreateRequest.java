package com.example.springproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeCreateRequest {
    private String name;
    private String surname;
    private String patronymic;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String email;
    private String myPhoto;
    private String aboutMe;

    // Геттеры и сеттеры для всех полей

    // Конструкторы

    // Дополнительные методы, если необходимо
}
