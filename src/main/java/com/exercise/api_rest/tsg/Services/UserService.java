package com.exercise.api_rest.tsg.Services;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.exercise.api_rest.tsg.Dto.CreateUserDto;
import com.exercise.api_rest.tsg.Dto.UpdateUserDto;
import com.exercise.api_rest.tsg.Models.User;
import com.exercise.api_rest.tsg.Repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User createUser(CreateUserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRegistrationDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    public User updateUser(Integer id, UpdateUserDto userDetails) {
        User existentUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existentUser.setName(userDetails.getName() != null ? userDetails.getName() : existentUser.getName());
        existentUser.setEmail(userDetails.getEmail() != null ? userDetails.getEmail() : existentUser.getEmail());
        existentUser.setPassword(userDetails.getPassword() != null ? userDetails.getPassword() : existentUser.getPassword());
        existentUser.setRegistrationDate(existentUser.getRegistrationDate());
        return userRepository.save(existentUser);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}