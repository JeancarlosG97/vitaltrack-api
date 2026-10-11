package com.jeancarlos.vitaltrack.vitaltrackapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateGoalsRequest {
    private Double targetWeight;
    private Double targetSleepHours;
    private Integer targetWorkoutsPerWeek;
}
