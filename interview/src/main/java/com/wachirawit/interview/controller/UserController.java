package com.wachirawit.interview.controller;

import com.wachirawit.interview.model.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserController {

    public ResponseEntity<List<User>> getAllUsers();

    public ResponseEntity<User> getUserById(@PathVariable long id);

    public ResponseEntity<User> createUser(@Valid @RequestBody User user);

    public ResponseEntity<User> updateUser(@PathVariable long userId, @Valid @RequestBody User user);

    public ResponseEntity<User> deleteUser(@PathVariable long userId);
}
