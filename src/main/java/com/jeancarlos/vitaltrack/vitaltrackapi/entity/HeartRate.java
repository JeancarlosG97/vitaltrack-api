package com.jeancarlos.vitaltrack.vitaltrackapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "heart_rates")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeartRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private int heartRate;

    private LocalDateTime recordedAt = LocalDateTime.now();
}