package com.jeancarlos.vitaltrack.vitaltrackapi.controller;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.CreateWorkoutRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.User;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.Workout;
import com.jeancarlos.vitaltrack.vitaltrackapi.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @PostMapping
    public Workout save(@RequestBody CreateWorkoutRequest createWorkoutRequest) {
        Long userId = 1L;

        return workoutService.createWorkout(createWorkoutRequest, userId);
    }

    @GetMapping
    public List<Workout> getWorkoutById() {
        Long userId = 1L;

        return workoutService.getWorkouts(userId);
    }
}