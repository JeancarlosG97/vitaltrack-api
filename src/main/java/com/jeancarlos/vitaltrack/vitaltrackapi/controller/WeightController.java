package com.jeancarlos.vitaltrack.vitaltrackapi.controller;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.CreateWeightRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.Weight;
import com.jeancarlos.vitaltrack.vitaltrackapi.service.WeightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weights")
@RequiredArgsConstructor
public class WeightController {

    private final WeightService weightService;

    @PostMapping
    public Weight save(@RequestBody CreateWeightRequest createWeightRequest) {
        Long userId = 1L;

        return weightService.createWeight(createWeightRequest, userId);
    }

    @GetMapping
    public List<Weight> getWeights() {
        Long userId = 1L;
        return weightService.getWeights(userId);
    }
}
