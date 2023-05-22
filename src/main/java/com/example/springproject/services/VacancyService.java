package com.example.springproject.services;

import com.example.springproject.models.User;
import com.example.springproject.models.Vacancy;
import com.example.springproject.repositories.UserRepository;
import com.example.springproject.repositories.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyService {
    private VacancyRepository vacancyRepository;
    private UserRepository userRepository;

    @Autowired
    public VacancyService(VacancyRepository vacancyRepository, UserRepository userRepository) {
        this.vacancyRepository = vacancyRepository;
        this.userRepository = userRepository;
    }

    public List<Vacancy> getVacancies(){
        return vacancyRepository.findAll();
    }

    public void addNewVacancy(Vacancy vacancy) {
        Optional<Vacancy> vacancyOptional= Optional.ofNullable(vacancyRepository.getReferenceById(vacancy.getId()));
        if (vacancyOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        vacancyRepository.save(vacancy);
    }
    public void deleteVacancy(Long vacancyId) {
        boolean exists = vacancyRepository.existsById(vacancyId);
        if(!exists){
            throw new IllegalStateException("vacancy with id " + vacancyId+" does not exists");
        }
        vacancyRepository.deleteById(vacancyId);
    }

    // Другие методы, связанные с вакансиями
}

