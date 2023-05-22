package com.example.springproject.configs;


import com.example.springproject.models.User;
import com.example.springproject.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User ilya = new User(
                    "ilya",
                    "1111",
                    "ilya@email.ru"
            );
            User andrew = new User(
                    "andrew",
                    "0000",
                    "andrew@email.ru"
            );

            repository.saveAll(List.of(ilya,andrew));
        };
    }
}
