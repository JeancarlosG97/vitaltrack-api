package com.jeancarlos.vitaltrack.vitaltrackapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserProfileResponse {
    private Long id;
    private String username;
    private String email;
    private Double targetWeight;
    private Double targetSleepHours;
    private Integer targetWorkoutsPerWeek;
}