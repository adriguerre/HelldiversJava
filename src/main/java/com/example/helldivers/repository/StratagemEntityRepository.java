package com.example.helldivers.repository;

import com.example.helldivers.domain.StratagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StratagemEntityRepository extends JpaRepository<StratagemEntity, Integer> {

    Optional<StratagemEntity> findByStratagem_StratagemId(Integer stratagemId);
}
