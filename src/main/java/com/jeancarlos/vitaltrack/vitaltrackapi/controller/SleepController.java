package com.jeancarlos.vitaltrack.vitaltrackapi.controller;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.CreateSleepRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.Sleep;
import com.jeancarlos.vitaltrack.vitaltrackapi.service.SleepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sleep-records")
@RequiredArgsConstructor
public class SleepController {

    private final SleepService sleepService;

    @PostMapping
    public Sleep save(@RequestBody CreateSleepRequest request) {
        Long userId = 1L;

        return sleepService.createSleep(request, userId);
    }

    @GetMapping
    public List<Sleep> getSleepRecords() {
        Long userId = 1L;

        return sleepService.getSleepRecords(userId);
    }
}