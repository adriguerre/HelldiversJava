package com.example.helldivers.repository;

import com.example.helldivers.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Integer>, JpaSpecificationExecutor<Mission> {

    @Query("SELECT m FROM Mission m JOIN FETCH m.planet WHERE m.missionId = :id")
    Optional<Mission> findByIdWithPlanet(@Param("id") Integer id);
}
