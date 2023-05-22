package com.example.springproject.repositories;
import com.example.springproject.models.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    // Дополнительные методы для выполнения специфичных запросов к базе данных, если необходимо
}
