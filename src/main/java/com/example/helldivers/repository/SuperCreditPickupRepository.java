package com.example.helldivers.repository;

import com.example.helldivers.domain.SuperCreditPickup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuperCreditPickupRepository extends JpaRepository<SuperCreditPickup, Integer> {

    Optional<SuperCreditPickup> findByPickupIdAndMissionId(Integer pickupId, Integer missionId);
}
