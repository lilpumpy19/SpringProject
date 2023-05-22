//package com.example.springproject.student;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class StudentConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner1(StudentRepository repository){
//        return args -> {
//            Student ilya = new Student(
//                    1L,
//                    "Ilya",
//                    "ilya@mail.com",
//                    LocalDate.of(2003, Month.AUGUST,4)
//            );
//
//            Student andrew = new Student(
//                    "andrew",
//                    "andrew@mail.com",
//                    LocalDate.of(2002, Month.FEBRUARY,3)
//            );
//
//            repository.saveAll(
//                    List.of(ilya,andrew)
//            );
//        };
//    }
//}
