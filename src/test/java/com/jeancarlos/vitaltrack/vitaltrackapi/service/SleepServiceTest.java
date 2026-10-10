package com.jeancarlos.vitaltrack.vitaltrackapi.service;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.CreateSleepRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.Sleep;
import com.jeancarlos.vitaltrack.vitaltrackapi.repository.SleepRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SleepServiceTest {

    @Mock
    private SleepRepository sleepRepository;

    @InjectMocks
    private SleepService sleepService;

    @Test
    void createSleep_ShouldSaveSleep() {

        CreateSleepRequest request =
                new CreateSleepRequest();

        request.setHoursSlept(8.0);

        Sleep sleep = new Sleep();
        sleep.setId(1L);

        when(sleepRepository.save(any(Sleep.class)))
                .thenReturn(sleep);

        Sleep result =
                sleepService.createSleep(request, 1L);

        assertNotNull(result);

        verify(sleepRepository)
                .save(any(Sleep.class));
    }

    @Test
    void getSleepRecords_ShouldReturnSleepRecords() {

        Sleep sleep = new Sleep();

        when(sleepRepository.findByUserId(1L))
                .thenReturn(List.of(sleep));

        List<Sleep> result =
                sleepService.getSleepRecords(1L);

        assertEquals(1, result.size());
    }
}