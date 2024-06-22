package com.abhishek.fakestore.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.abhishek.fakestore.api.model.LoginRequest;
import com.abhishek.fakestore.api.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // add authentication logic
        return authService.login(loginRequest.getUsername(), loginRequest.getPassword());
    }
}
