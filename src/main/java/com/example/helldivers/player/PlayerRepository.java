package com.example.helldivers.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    void deleteById(Long playerId);
    Optional<Player> findByUsername(String username);
    Optional<Player> findById(Long id);
}
