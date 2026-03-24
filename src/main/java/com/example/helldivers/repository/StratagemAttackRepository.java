package com.example.helldivers.repository;

import com.example.helldivers.domain.StratagemAttack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StratagemAttackRepository extends JpaRepository<StratagemAttack, Integer> {

    List<StratagemAttack> findByStratagem_StratagemId(Integer stratagemId);
}
