package com.jeancarlos.vitaltrack.vitaltrackapi.service;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.LoginRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.dto.RegisterRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.User;
import com.jeancarlos.vitaltrack.vitaltrackapi.exception.EmailAlreadyExistsException;
import com.jeancarlos.vitaltrack.vitaltrackapi.exception.InvalidCredentialsException;
import com.jeancarlos.vitaltrack.vitaltrackapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(RegisterRequest request) {
        Optional<User> existingUser =
                userRepository.findByEmail(request.getEmail());

        if (existingUser.isPresent()) {
            throw new EmailAlreadyExistsException("Email already registered.");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user);
    }

    public String login(LoginRequest request) {
        Optional<User> existingUser =
                userRepository.findByEmail(request.getEmail());

        if (existingUser.isEmpty()) {
            throw new InvalidCredentialsException("Invalid credentials.");
        }

        boolean passwordMatches =
                passwordEncoder.matches(request.getPassword(),
                        existingUser.get().getPassword());

        if (!passwordMatches) {
            throw new InvalidCredentialsException("Invalid credentials.");
        }

        return "Login successful!";
    }
}