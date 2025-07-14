package com.wachirawit.interview.controller;

import com.wachirawit.interview.model.User;
import com.wachirawit.interview.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControllerImp implements UserController {

    UserService userService;

    @Autowired
    public UserControllerImp(UserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable long userId) {
        return userService.getUserById(userId);
    }

    @Override
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @Override
    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable long userId, @Valid @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @Override
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable long userId) {
        return userService.deleteUser(userId);
    }
}
