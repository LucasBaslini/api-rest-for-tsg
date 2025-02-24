package com.exercise.api_rest.tsg.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreatePostDTO {
    
    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Content cannot be empty")
    private String content;

    @NotNull(message = "User ID is required")
    private Integer userId;    
}