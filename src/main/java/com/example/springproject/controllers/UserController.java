package com.example.springproject.controllers;

import com.example.springproject.models.User;
import com.example.springproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping( consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void registerNewUser(@ModelAttribute User user) {
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/get")
    public ResponseEntity<User> getUser(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        User user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    protected static User getCurrentUser() {
        // Получить объект аутентификации из контекста SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Проверить, что аутентификация прошла успешно и аутентифицированный объект не является анонимным
        if (authentication != null && authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof String)) {
            // Получить объект пользователя из аутентификации
            User user = (User) authentication.getPrincipal();
            return user;
        }

        // Если текущего пользователя нет или он является анонимным, вернуть null или выполнить другое действие по вашему усмотрению
        return null;
    }


}
