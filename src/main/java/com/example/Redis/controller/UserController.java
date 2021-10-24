package com.example.Redis.controller;

import com.example.Redis.model.User;
import com.example.Redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user) {
        boolean userSaved = userService.saveUser(user);
        if(userSaved) {
            return "User saved successfully";
        } else{
            return "Exception Occured";
        }
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List> fetchUsers() {
        List<User> userList = userService.fetchUsers();
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping("/userById/{id}")
    public ResponseEntity<User> fetchUserById(@PathVariable("id") Long id) {
        User user = userService.fetchUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        Boolean isDeleted = userService.deleteUser(id);
        return isDeleted ?  ResponseEntity.ok("Deleted successfully") : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
