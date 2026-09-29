package com.jeancarlos.vitaltrack.vitaltrackapi.repository;

import com.jeancarlos.vitaltrack.vitaltrackapi.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}
