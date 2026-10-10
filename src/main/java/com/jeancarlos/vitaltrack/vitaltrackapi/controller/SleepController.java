package com.jeancarlos.vitaltrack.vitaltrackapi.controller;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.CreateSleepRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.Sleep;
import com.jeancarlos.vitaltrack.vitaltrackapi.service.JwtService;
import com.jeancarlos.vitaltrack.vitaltrackapi.service.SleepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sleep-records")
@RequiredArgsConstructor
public class SleepController {

    private final SleepService sleepService;
    private final JwtService jwtService;

    @PostMapping
    public Sleep save(@RequestHeader("Authorization") String authHeader, @RequestBody CreateSleepRequest request) {
        Long userId = getUserIdFromToken(authHeader);

        return sleepService.createSleep(request, userId);
    }

    @GetMapping
    public List<Sleep> getSleepRecords(@RequestHeader("Authorization") String authHeader) {
        Long userId = getUserIdFromToken(authHeader);

        return sleepService.getSleepRecords(userId);
    }

    private Long getUserIdFromToken(String authHeader) {
        String token = authHeader.substring(7);
        return jwtService.extractUserId(token);
    }
}