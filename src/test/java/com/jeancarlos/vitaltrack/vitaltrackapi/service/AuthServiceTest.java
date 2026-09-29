package com.jeancarlos.vitaltrack.vitaltrackapi.service;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.LoginRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.dto.RegisterRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.User;
import com.jeancarlos.vitaltrack.vitaltrackapi.exception.EmailAlreadyExistsException;
import com.jeancarlos.vitaltrack.vitaltrackapi.exception.InvalidCredentialsException;
import com.jeancarlos.vitaltrack.vitaltrackapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private AuthService authService;

    @Test
    void register_ShouldSaveUser_WhenEmailDoesNotExist() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("jean");
        request.setEmail("jean@email.com");
        request.setPassword("password123");

        when(userRepository.findByEmail(request.getEmail()))
                .thenReturn(Optional.empty());

        when(passwordEncoder.encode(request.getPassword()))
                .thenReturn("hashedPassword");

        User savedUser = new User();
        savedUser.setId(1L);

        when(userRepository.save(any(User.class)))
                .thenReturn(savedUser);

        User result = authService.register(request);

        assertNotNull(result);
        verify(userRepository).save(any(User.class));
    }

    @Test
    void register_ShouldThrowException_WhenEmailExists() {
        RegisterRequest request = new RegisterRequest();
        request.setEmail("jean@email.com");

        when(userRepository.findByEmail(request.getEmail()))
                .thenReturn(Optional.of(new User()));

        assertThrows(
                EmailAlreadyExistsException.class,
                () -> authService.register(request)
        );
    }

    @Test
    void login_ShouldReturnToken_WhenCredentialsValid() {
        LoginRequest request = new LoginRequest();
        request.setEmail("jean@email.com");
        request.setPassword("password123");

        User user = new User();
        user.setId(1L);
        user.setPassword("hashedPassword");

        when(userRepository.findByEmail(request.getEmail()))
                .thenReturn(Optional.of(user));

        when(passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()))
                .thenReturn(true);

        when(jwtService.generateToken(user))
                .thenReturn("jwt-token");

        String token = authService.login(request);

        assertEquals("jwt-token", token);
    }

    @Test
    void login_ShouldThrowException_WhenUserDoesNotExist() {
        LoginRequest request = new LoginRequest();
        request.setEmail("missing@email.com");

        when(userRepository.findByEmail(request.getEmail()))
                .thenReturn(Optional.empty());

        assertThrows(
                InvalidCredentialsException.class,
                () -> authService.login(request)
        );
    }

    @Test
    void login_ShouldThrowException_WhenPasswordIsWrong() {
        LoginRequest request = new LoginRequest();
        request.setEmail("jean@email.com");
        request.setPassword("wrongpassword");

        User user = new User();
        user.setPassword("hashedPassword");

        when(userRepository.findByEmail(request.getEmail()))
                .thenReturn(Optional.of(user));

        when(passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()))
                .thenReturn(false);

        assertThrows(
                InvalidCredentialsException.class,
                () -> authService.login(request)
        );
    }
}