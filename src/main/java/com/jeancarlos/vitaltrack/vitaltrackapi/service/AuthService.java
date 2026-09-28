package com.jeancarlos.vitaltrack.vitaltrackapi.service;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.RegisterRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.User;
import com.jeancarlos.vitaltrack.vitaltrackapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public User register(RegisterRequest request) {
        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        Optional<User> existingUser =
                userRepository.findByEmail(request.getEmail());

        if(existingUser.isPresent()) {
            throw new RuntimeException("Email already registered.");
        }

        return userRepository.save(user);
    }
}