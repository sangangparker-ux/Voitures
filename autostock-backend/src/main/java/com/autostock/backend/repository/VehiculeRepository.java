package com.autostock.backend.repository;

import com.autostock.backend.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}
