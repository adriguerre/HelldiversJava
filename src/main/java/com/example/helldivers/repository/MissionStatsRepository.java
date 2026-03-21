package com.example.helldivers.repository;

import com.example.helldivers.domain.MissionStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionStatsRepository extends JpaRepository<MissionStats, Integer> {


    List<MissionStats> findMissionStatsByMissionIdIs(Integer missionId);
}
