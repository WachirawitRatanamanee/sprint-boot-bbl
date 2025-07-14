package com.wachirawit.interview.service;

import com.wachirawit.interview.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    List<User> users = new ArrayList<>(Arrays.asList(
            new User(1,
                    "Leanne Graham",
                    "Bret",
                    "Sincere@april.biz",
                    "1-770-736-8031 x56442",
                    "hildegard.org"),
            new User(
                    2,
                    "Ervin Howell",
                    "Antonette",
                    "Shanna@melissa.tv",
                    "010-692-6593 x09125",
                    "anastasia.net"
            ),
            new User(
                    3,
                    "Clementine Bauch",
                    "Samantha",
                    "Nathan@yesenia.net",
                    "1-463-123-4447",
                    "ramiro.info"
            )
    ));

    private long lastId = users.size();

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(this.users);
    }

    @Override
    public ResponseEntity<User> getUserById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        lastId++;
        user.setId(lastId);
        users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @Override
    public ResponseEntity<User> updateUser(long userId, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId) {
                user.setId(userId);
                users.set(i, user);
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<User> deleteUser(long userId) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId) {
                User deletedUser = users.get(i);
                users.remove(i);
                return ResponseEntity.ok(deletedUser);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
