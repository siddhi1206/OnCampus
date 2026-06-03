package com.oncampus.controller;

import com.oncampus.dto.LoginRequest;
import com.oncampus.dto.LoginResponse;
import com.oncampus.dto.RegisterRequest;
import com.oncampus.model.User;
import com.oncampus.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register-educator")
    public User registerEducator(@RequestBody RegisterRequest request) {
        return authService.registerEducator(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}