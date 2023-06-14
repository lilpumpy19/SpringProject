package com.example.springproject.repositories;
import com.example.springproject.models.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findAll();
    List<Vacancy> findByLocation(String location);
    List<Vacancy> findByJobTitle(String jobTitle);
    List<Vacancy> findByJobTitleAndLocation(String jobTitle, String location);

    List<Vacancy> findByUserId(Long id);
}
