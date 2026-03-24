package com.example.helldivers.repository;

import com.example.helldivers.domain.Ammo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AmmoRepository extends JpaRepository<Ammo, Integer>, JpaSpecificationExecutor<Ammo> {
}
