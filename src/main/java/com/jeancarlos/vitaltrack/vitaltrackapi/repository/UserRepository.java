package com.jeancarlos.vitaltrack.vitaltrackapi.repository;

import com.jeancarlos.vitaltrack.vitaltrackapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
