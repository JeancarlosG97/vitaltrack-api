package com.jeancarlos.vitaltrack.vitaltrackapi.service;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.CreateSleepRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.Sleep;
import com.jeancarlos.vitaltrack.vitaltrackapi.repository.SleepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SleepService {

    private final SleepRepository sleepRepository;

    public Sleep createSleep(CreateSleepRequest request, Long userId) {
        Sleep sleep = new Sleep();

        sleep.setUserId(userId);
        sleep.setHoursSlept(request.getHoursSlept());

        return sleepRepository.save(sleep);
    }

    public List<Sleep> getSleepRecords(Long userId) {
        return sleepRepository.findByUserId(userId);
    }
}
