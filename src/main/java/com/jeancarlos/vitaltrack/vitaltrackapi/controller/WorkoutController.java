package com.jeancarlos.vitaltrack.vitaltrackapi.controller;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.CreateWorkoutRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.Workout;
import com.jeancarlos.vitaltrack.vitaltrackapi.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}