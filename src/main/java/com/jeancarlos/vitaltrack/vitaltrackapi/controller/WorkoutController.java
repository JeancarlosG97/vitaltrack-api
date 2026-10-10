package com.jeancarlos.vitaltrack.vitaltrackapi.controller;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.CreateWorkoutRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.Workout;
import com.jeancarlos.vitaltrack.vitaltrackapi.service.JwtService;
import com.jeancarlos.vitaltrack.vitaltrackapi.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;
    private final JwtService jwtService;

    @PostMapping
    public Workout save(@RequestHeader("Authorization") String authHeader, @RequestBody CreateWorkoutRequest createWorkoutRequest) {
        Long userId = getUserIdFromToken(authHeader);

        return workoutService.createWorkout(createWorkoutRequest, userId);
    }

    @GetMapping
    public List<Workout> getWorkouts(@RequestHeader("Authorization") String authHeader) {
        Long userId = getUserIdFromToken(authHeader);

        return workoutService.getWorkouts(userId);
    }

    private Long getUserIdFromToken(String authHeader) {
        String token = authHeader.substring(7);
        return jwtService.extractUserId(token);
    }
}