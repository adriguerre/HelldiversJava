package com.example.helldivers.repository;

import com.example.helldivers.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlanetRepository extends JpaRepository<Planet, Integer>, JpaSpecificationExecutor<Planet> {
}
