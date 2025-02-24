package com.exercise.api_rest.tsg.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateUserDto {
    
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;
    
    @Email(message = "Invalid email format")
    private String email;
    
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
}