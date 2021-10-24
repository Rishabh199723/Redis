package com.example.Redis.repository;

import com.example.Redis.model.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    boolean saveUser(User user);

    List<User> fetchAllUsers();

    User fetchUserById(Long id);

    Boolean deleteUser(Long id);
}
