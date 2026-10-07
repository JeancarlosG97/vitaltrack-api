package com.jeancarlos.vitaltrack.vitaltrackapi.service;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.CreateWorkoutRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.Workout;
import com.jeancarlos.vitaltrack.vitaltrackapi.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public Workout createWorkout(CreateWorkoutRequest request, Long userId) {
        Workout workout = new Workout();

        workout.setUserId(userId);
        workout.setType(request.getType());
        workout.setDurationMinutes(request.getDurationMinutes());
        workout.setCaloriesBurned(request.getCaloriesBurned());

        return workoutRepository.save(workout);
    }

    public List<Workout> getWorkouts(Long userId) {
        return workoutRepository.findByUserId(userId);
    }
}