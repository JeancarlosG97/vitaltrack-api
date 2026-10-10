package com.jeancarlos.vitaltrack.vitaltrackapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "sleep_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sleep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private double hoursSlept;

    private LocalDateTime recordedAt = LocalDateTime.now();
}
