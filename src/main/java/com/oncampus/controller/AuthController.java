package com.oncampus.controller;

import com.oncampus.dto.RegisterRequest;
import com.oncampus.model.User;
import com.oncampus.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}