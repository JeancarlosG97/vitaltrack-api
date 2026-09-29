package com.jeancarlos.vitaltrack.vitaltrackapi.dto;

import lombok.Data;

@Data
public class CreateWorkoutRequest {
    private String type;
    private int durationMinutes;
    private int caloriesBurned;
}
