package com.example.springproject.repositories;

import com.example.springproject.models.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    Resume findByUserId(Long id);
    // Дополнительные методы для выполнения специфичных запросов к базе данных, если необходимо
}