package com.exercise.api_rest.tsg.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.api_rest.tsg.Requests.AuthRequest;
import com.exercise.api_rest.tsg.Requests.AuthResponse;
import com.exercise.api_rest.tsg.Requests.RegisterRequest;
import com.exercise.api_rest.tsg.Requests.RegisterResponse;
import com.exercise.api_rest.tsg.Services.AuthService;
import com.exercise.api_rest.tsg.Services.RegisterService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(registerService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}