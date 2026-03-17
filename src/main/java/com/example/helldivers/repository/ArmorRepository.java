package com.example.helldivers.repository;

import com.example.helldivers.domain.Armor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArmorRepository extends JpaRepository<Armor, Integer>, JpaSpecificationExecutor<Armor> {

    Optional<Armor> findByName(String name);
}
