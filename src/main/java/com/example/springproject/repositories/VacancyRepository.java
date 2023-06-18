package com.example.springproject.repositories;
import com.example.springproject.models.Resume;
import com.example.springproject.models.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT v.applicants FROM Vacancy v WHERE v.id = :vacancyId")
    List<Resume> findApplicantsByVacancyId(Long vacancyId);

    @Modifying
    @Query(value = "DELETE FROM vacancy_applicants WHERE vacancy_id = :vacancyId AND resume_id = :resumeId", nativeQuery = true)
    void deleteApplicantByVacancyIdAndResumeId(Long vacancyId, Long resumeId);






}
