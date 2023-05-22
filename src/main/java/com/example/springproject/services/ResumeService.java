package com.example.springproject.services;

import com.example.springproject.models.Resume;
import com.example.springproject.models.User;
import com.example.springproject.repositories.ResumeRepository;
import com.example.springproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {
    private ResumeRepository resumeRepository;
    private UserRepository userRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository, UserRepository userRepository) {
        this.resumeRepository = resumeRepository;
        this.userRepository = userRepository;
    }

    public Resume createResume(Long userId, String title, String description,int experience) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Resume resume = new Resume();
        resume.setUser(user);
        resume.setTitle(title);
        resume.setDescription(description);
        resume.setExperience(experience);

        return resumeRepository.save(resume);
    }

    public void deleteResume(Long id){
        boolean exists = resumeRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("student with id " + id+" does not exists");
        }
        resumeRepository.deleteById(id);
    }



    // Другие методы, связанные с резюме
}

