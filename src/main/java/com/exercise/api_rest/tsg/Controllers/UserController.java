package com.exercise.api_rest.tsg.Controllers;

import com.exercise.api_rest.tsg.Dto.CreateUserDto;
import com.exercise.api_rest.tsg.Dto.UpdateUserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.exercise.api_rest.tsg.Models.User;
import com.exercise.api_rest.tsg.Services.UserService;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.ok(userService.createUser(createUserDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Integer id, 
            @Valid @RequestBody UpdateUserDto updateUserDto) {
        return ResponseEntity.ok(userService.updateUser(id, updateUserDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
