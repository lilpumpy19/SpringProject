package com.example.springproject.models;

import jakarta.persistence.*;

@Entity
@Table(name = "vacancies")
public class Vacancy {
    @Id
    @SequenceGenerator(
            name = "vacancy_sequence",
            sequenceName = "vacancy_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vacancy_sequence"
    )
    private Long id;

    public Vacancy(String jobTitle, String location) {
        this.jobTitle = jobTitle;
        this.location = location;
    }

    public Vacancy(String jobTitle, String location, int salary) {
        this.jobTitle = jobTitle;
        this.location = location;
        this.salary = salary;
    }

    public Vacancy() {
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String jobTitle;

    @Column
    private String location;

    @Column(length = 1000)
    private String description;

    @Column
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Дополнительные поля вакансии (требования, условия работы, зарплата и т.д.)

    // Геттеры и сеттеры, конструкторы и другие необходимые методы
}

