package com.jeancarlos.vitaltrack.vitaltrackapi.repository;

import com.jeancarlos.vitaltrack.vitaltrackapi.entity.HeartRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeartRateRepository extends JpaRepository<HeartRate, Long> {

    List<HeartRate> findByUserId(Long userId);
}