package com.exercise.api_rest.tsg.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.exercise.api_rest.tsg.Requests.AuthRequest;
import com.exercise.api_rest.tsg.Requests.AuthResponse;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtService jwtService;

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
            )
        );

        UserDetails user = userService.loadUserByUsername(request.getEmail());
        String token = jwtService.generateToken(user);

        return AuthResponse.builder()
                .token(token)
                .build();
    }
}