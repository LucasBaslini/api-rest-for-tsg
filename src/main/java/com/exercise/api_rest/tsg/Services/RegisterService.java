package com.exercise.api_rest.tsg.Services;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exercise.api_rest.tsg.Models.User;
import com.exercise.api_rest.tsg.Repository.UserRepository;
import com.exercise.api_rest.tsg.Requests.RegisterRequest;
import com.exercise.api_rest.tsg.Requests.RegisterResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterResponse register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .registrationDate(LocalDateTime.now())
                .build();

        userRepository.save(user);

        return RegisterResponse.builder()
                .message("User registered successfully, can login")
                .build();
    }
}