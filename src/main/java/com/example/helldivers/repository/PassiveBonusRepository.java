package com.example.helldivers.repository;

import com.example.helldivers.domain.PassiveBonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassiveBonusRepository extends JpaRepository<PassiveBonus, Integer> {
}
