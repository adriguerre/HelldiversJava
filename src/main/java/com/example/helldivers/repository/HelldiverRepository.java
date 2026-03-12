package com.example.helldivers.repository;

import com.example.helldivers.domain.Helldiver;
import com.example.helldivers.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HelldiverRepository extends JpaRepository<Helldiver, Integer> {

    //void deleteById(Long helldiver_id);
    //Optional<Player> findByUsername(String username);
    //Optional<Player> findById(Long id);
}
