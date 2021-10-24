package com.example.Redis.service;

import com.example.Redis.model.User;
import com.example.Redis.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public boolean saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public List<User> fetchUsers() {
        return userDao.fetchAllUsers();
    }

    @Override
    public User fetchUserById(Long id) {
        return userDao.fetchUserById(id);
    }

    @Override
    public Boolean deleteUser(Long id) {
        return userDao.deleteUser(id);
    }
}
