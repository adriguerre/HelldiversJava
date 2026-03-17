package com.example.helldivers.repository;

import com.example.helldivers.domain.Stratagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StratagemRepository extends JpaRepository<Stratagem, Integer>{

}
