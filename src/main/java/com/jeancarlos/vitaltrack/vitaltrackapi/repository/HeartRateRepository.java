package com.jeancarlos.vitaltrack.vitaltrackapi.repository;

import com.jeancarlos.vitaltrack.vitaltrackapi.entity.HeartRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeartRateRepository extends JpaRepository<HeartRate, Long> {

    List<HeartRate> findByUserId(Long userId);
}