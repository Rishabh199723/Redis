package com.example.Redis.service;

import com.example.Redis.model.User;

import java.util.List;


public interface UserService {
    boolean saveUser(User user);

    List<User> fetchUsers();

    User fetchUserById(Long id);

    Boolean deleteUser(Long id);
}
