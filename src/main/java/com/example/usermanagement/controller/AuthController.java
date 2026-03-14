package com.example.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.usermanagement.repository.UserRepository;
import com.example.usermanagement.security.JwtUtil;
import com.example.usermanagement.entity.User;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser = userRepository.findByEmail(user.getEmail()).orElse(null);

        if (dbUser != null && passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
            return jwtUtil.generateToken(dbUser.getEmail());
        }

        return "Invalid credentials";
    }
}