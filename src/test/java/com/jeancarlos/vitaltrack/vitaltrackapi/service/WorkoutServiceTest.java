package com.jeancarlos.vitaltrack.vitaltrackapi.service;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.CreateWorkoutRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.Workout;
import com.jeancarlos.vitaltrack.vitaltrackapi.repository.WorkoutRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WorkoutServiceTest {

    @Mock
    private WorkoutRepository workoutRepository;

    @InjectMocks
    private WorkoutService workoutService;

    @Test
    void createWorkout_ShouldSaveWorkout() {

        CreateWorkoutRequest request = new CreateWorkoutRequest();
        request.setType("Running");
        request.setDurationMinutes(45);
        request.setCaloriesBurned(500);

        Workout workout = new Workout();
        workout.setId(1L);

        when(workoutRepository.save(any(Workout.class)))
                .thenReturn(workout);

        Workout result =
                workoutService.createWorkout(request, 1L);

        assertNotNull(result);
        verify(workoutRepository).save(any(Workout.class));
    }

    @Test
    void getWorkouts_ShouldReturnWorkouts() {

        Workout workout = new Workout();

        when(workoutRepository.findByUserId(1L))
                .thenReturn(List.of(workout));

        List<Workout> result =
                workoutService.getWorkouts(1L);

        assertEquals(1, result.size());
    }
}