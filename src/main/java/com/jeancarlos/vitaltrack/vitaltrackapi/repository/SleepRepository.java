package com.jeancarlos.vitaltrack.vitaltrackapi.repository;

import com.jeancarlos.vitaltrack.vitaltrackapi.entity.Sleep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SleepRepository extends JpaRepository<Sleep, Long> {

    List<Sleep> findByUserId(Long userId);
}
