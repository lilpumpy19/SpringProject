package com.example.springproject.services;

import com.example.springproject.models.User;
import com.example.springproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional= Optional.ofNullable(userRepository.findByUsername(user.getUsername()));
        if (userOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException("user with id " + userId+" does not exists");
        }
        userRepository.deleteById(userId);
    }











//    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public User registerUser(String username, String password, String email) {
//        User existingUser = userRepository.findByUsername(username);
//        if (existingUser != null) {
//            throw new RuntimeException("Username already exists");
//        }
//
//        String encodedPassword = passwordEncoder.encode(password);
//
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(encodedPassword);
//        user.setEmail(email);
//
//        return userRepository.save(user);
//    }

    // Другие методы, связанные с пользователями
}
