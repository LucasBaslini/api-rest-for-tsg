package com.exercise.api_rest.tsg.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exercise.api_rest.tsg.Models.User;
import com.exercise.api_rest.tsg.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Integer id, User userDetails) {
        User existentUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userRepository.save(existentUser);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}