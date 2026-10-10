package com.jeancarlos.vitaltrack.vitaltrackapi.service;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.CreateWeightRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.Weight;
import com.jeancarlos.vitaltrack.vitaltrackapi.repository.WeightRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WeightServiceTest {

    @Mock
    private WeightRepository weightRepository;

    @InjectMocks
    private WeightService weightService;

    @Test
    void createWeight_ShouldSaveWeight() {

        CreateWeightRequest request =
                new CreateWeightRequest();

        request.setWeight(180.5);

        Weight weight = new Weight();
        weight.setId(1L);

        when(weightRepository.save(any(Weight.class)))
                .thenReturn(weight);

        Weight result =
                weightService.createWeight(request, 1L);

        assertNotNull(result);

        verify(weightRepository)
                .save(any(Weight.class));
    }

    @Test
    void getWeights_ShouldReturnWeights() {

        Weight weight = new Weight();

        when(weightRepository.findByUserId(1L))
                .thenReturn(List.of(weight));

        List<Weight> result =
                weightService.getWeights(1L);

        assertEquals(1, result.size());
    }
}