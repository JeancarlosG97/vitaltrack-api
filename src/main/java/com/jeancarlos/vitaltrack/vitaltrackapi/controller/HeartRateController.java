package com.jeancarlos.vitaltrack.vitaltrackapi.controller;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.CreateHeartRateRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.HeartRate;
import com.jeancarlos.vitaltrack.vitaltrackapi.service.HeartRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heart-rates")
@RequiredArgsConstructor
public class HeartRateController {

    private final HeartRateService heartRateService;

    @PostMapping
    public HeartRate save(@RequestBody CreateHeartRateRequest createHeartRateRequest) {
        Long userId = 1L;

        return heartRateService.createHeartRate(createHeartRateRequest, userId);
    }

    @GetMapping
    public List<HeartRate> getHeartRates() {
        Long userId = 1L;

        return heartRateService.getHeartRates(userId);
    }
}
