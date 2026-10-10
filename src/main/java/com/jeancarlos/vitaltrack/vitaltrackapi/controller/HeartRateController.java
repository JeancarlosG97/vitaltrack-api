package com.jeancarlos.vitaltrack.vitaltrackapi.controller;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.CreateHeartRateRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.HeartRate;
import com.jeancarlos.vitaltrack.vitaltrackapi.service.HeartRateService;
import com.jeancarlos.vitaltrack.vitaltrackapi.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heart-rates")
@RequiredArgsConstructor
public class HeartRateController {

    private final HeartRateService heartRateService;
    private final JwtService jwtService;

    @PostMapping
    public HeartRate save(@RequestHeader("Authorization") String authHeader, @RequestBody CreateHeartRateRequest createHeartRateRequest) {
        Long userId = getUserIdFromToken(authHeader);

        return heartRateService.createHeartRate(createHeartRateRequest, userId);
    }

    @GetMapping
    public List<HeartRate> getHeartRates(@RequestHeader("Authorization") String authHeader) {
        Long userId = getUserIdFromToken(authHeader);

        return heartRateService.getHeartRates(userId);
    }

    private Long getUserIdFromToken(String authHeader) {
        String token = authHeader.substring(7);
        return jwtService.extractUserId(token);
    }
}
