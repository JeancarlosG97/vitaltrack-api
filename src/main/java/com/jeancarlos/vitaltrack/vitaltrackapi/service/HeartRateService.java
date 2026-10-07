package com.jeancarlos.vitaltrack.vitaltrackapi.service;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.CreateHeartRateRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.HeartRate;
import com.jeancarlos.vitaltrack.vitaltrackapi.repository.HeartRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeartRateService {

    private final HeartRateRepository heartRateRepository;

    public HeartRate createHeartRate(CreateHeartRateRequest request, Long userId) {
        HeartRate heartRate = new HeartRate();

        heartRate.setUserId(userId);
        heartRate.setHeartRate(request.getHeartRate());

        return heartRateRepository.save(heartRate);
    }

    public List<HeartRate> getHeartRates(Long userId) {
        return heartRateRepository.findByUserId(userId);
    }
}
