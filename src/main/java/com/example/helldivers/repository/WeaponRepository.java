package com.example.helldivers.repository;

import com.example.helldivers.domain.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer>, JpaSpecificationExecutor<Weapon> {

    Optional<Weapon> findByName(String name);
}
