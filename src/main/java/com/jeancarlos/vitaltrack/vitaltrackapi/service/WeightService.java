package com.jeancarlos.vitaltrack.vitaltrackapi.service;

import com.jeancarlos.vitaltrack.vitaltrackapi.dto.CreateWeightRequest;
import com.jeancarlos.vitaltrack.vitaltrackapi.entity.Weight;
import com.jeancarlos.vitaltrack.vitaltrackapi.repository.WeightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeightService {

    private final WeightRepository weightRepository;

    public Weight createWeight(CreateWeightRequest request, Long userId) {
        Weight weight = new Weight();

        weight.setUserId(userId);
        weight.setWeight(request.getWeight());

        return weightRepository.save(weight);
    }

    public List<Weight> getWeights(Long userId) {
        return weightRepository.findByUserId(userId);
    }
}