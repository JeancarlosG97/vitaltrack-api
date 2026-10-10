package com.jeancarlos.vitaltrack.vitaltrackapi.service;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.CreateHeartRateRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.HeartRate;
import com.jeancarlos.vitaltrack.vitaltrackapi.repository.HeartRateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HeartRateServiceTest {

    @Mock
    private HeartRateRepository heartRateRepository;

    @InjectMocks
    private HeartRateService heartRateService;

    @Test
    void createHeartRate_ShouldSaveHeartRate() {

        CreateHeartRateRequest request =
                new CreateHeartRateRequest();

        request.setHeartRate(72);

        HeartRate heartRate = new HeartRate();
        heartRate.setId(1L);

        when(heartRateRepository.save(any(HeartRate.class)))
                .thenReturn(heartRate);

        HeartRate result =
                heartRateService.createHeartRate(request, 1L);

        assertNotNull(result);

        verify(heartRateRepository)
                .save(any(HeartRate.class));
    }

    @Test
    void getHeartRates_ShouldReturnHeartRates() {

        HeartRate heartRate = new HeartRate();

        when(heartRateRepository.findByUserId(1L))
                .thenReturn(List.of(heartRate));

        List<HeartRate> result =
                heartRateService.getHeartRates(1L);

        assertEquals(1, result.size());
    }
}