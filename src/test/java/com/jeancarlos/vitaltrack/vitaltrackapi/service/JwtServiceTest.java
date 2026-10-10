package com.jeancarlos.vitaltrack.vitaltrackapi.service;

import com.jeancarlos.vitaltrack.vitaltrackapi.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class JwtServiceTest {

    private JwtService jwtService;

    @BeforeEach
    void setup() {

        jwtService = new JwtService();

        ReflectionTestUtils.setField(
                jwtService,
                "secret",
                "mySuperSecretJwtKeyForVitalTrackApplication123456789"
        );
    }

    @Test
    void shouldGenerateAndValidateToken() {

        User user = new User();
        user.setId(1L);

        String token =
                jwtService.generateToken(user);

        assertNotNull(token);

        assertTrue(
                jwtService.validateToken(token)
        );
    }

    @Test
    void shouldExtractUserId() {

        User user = new User();
        user.setId(5L);

        String token =
                jwtService.generateToken(user);

        Long userId =
                jwtService.extractUserId(token);

        assertEquals(5L, userId);
    }
}