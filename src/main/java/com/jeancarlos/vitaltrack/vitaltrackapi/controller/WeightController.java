package com.jeancarlos.vitaltrack.vitaltrackapi.controller;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.CreateWeightRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.Weight;
import com.jeancarlos.vitaltrack.vitaltrackapi.service.JwtService;
import com.jeancarlos.vitaltrack.vitaltrackapi.service.WeightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weights")
@RequiredArgsConstructor
public class WeightController {

    private final WeightService weightService;
    private final JwtService jwtService;

    @PostMapping
    public Weight save(@RequestHeader("Authorization") String authHeader, @RequestBody CreateWeightRequest createWeightRequest) {
        Long userId = getUserIdFromToken(authHeader);

        return weightService.createWeight(createWeightRequest, userId);
    }

    @GetMapping
    public List<Weight> getWeights(@RequestHeader("Authorization") String authHeader) {
        Long userId = getUserIdFromToken(authHeader);
        return weightService.getWeights(userId);
    }

    private Long getUserIdFromToken(String authHeader) {
        String token = authHeader.substring(7);
        return jwtService.extractUserId(token);
    }
}