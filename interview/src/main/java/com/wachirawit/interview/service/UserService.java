package com.wachirawit.interview.service;

import com.wachirawit.interview.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public ResponseEntity<List<User>> getAllUsers();

    public ResponseEntity<User> getUserById(long id);

    public ResponseEntity<User> createUser(User user);

    public ResponseEntity<User> updateUser(long userId, User user);

    public ResponseEntity<User> deleteUser(long userId);
}
