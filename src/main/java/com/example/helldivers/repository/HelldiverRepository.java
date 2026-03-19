package com.example.helldivers.repository;

import com.example.helldivers.domain.Helldiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HelldiverRepository extends JpaRepository<Helldiver, Integer>, JpaSpecificationExecutor<Helldiver> {

    void deleteByHelldiverId(Long helldiverId);
    Optional<Helldiver> findByCallSign(String callSign);
    Optional<Helldiver> findByHelldiverId(Long helldiverId);
}
