package com.example.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.service.UserService;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> viewUsers(){
        return userService.getAllUsers();
    }

}