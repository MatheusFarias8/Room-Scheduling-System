package com.Unichristus.Room_Scheduling_System.repositories;

import com.Unichristus.Room_Scheduling_System.domain.models.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SalaRepository extends JpaRepository<Sala, UUID> {
}
