package com.example.helldivers.repository;

import com.example.helldivers.domain.Stratagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StratagemRepository extends JpaRepository<Stratagem, Integer>, JpaSpecificationExecutor<Stratagem> {

    Optional<Stratagem> findByName(String name);
    Optional<Stratagem> findByBackpackSlot(Boolean backpack_slot);
    Optional<Stratagem> findByUsesPerMission(Integer uses_per_mission);

}
