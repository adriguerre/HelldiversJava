package com.example.helldivers.service;

import com.example.helldivers.domain.Helldiver;
import com.example.helldivers.domain.Mission;
import com.example.helldivers.domain.MissionStats;
import com.example.helldivers.repository.HelldiverRepository;
import com.example.helldivers.repository.MissionRepository;
import com.example.helldivers.repository.MissionStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
@Service
public class MissionStatsService {

    private final HelldiverRepository helldiverRepository;
    private final MissionRepository missionRepository;
    private final MissionStatsRepository missionStatsRepository;

    @Autowired
    public MissionStatsService(HelldiverRepository helldiverRepository, MissionRepository missionRepository, MissionStatsRepository missionStatsRepository) {
        this.helldiverRepository = helldiverRepository;

        this.missionRepository = missionRepository;
        this.missionStatsRepository = missionStatsRepository;
    }


    public Map<String, Object> saveStats(Integer missionId) {

        // 2. Find mission
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mission not found"));

        if(mission.getMissionStatsSaved())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mission stats already saved");

        //Find mission stats for this mission
        List<MissionStats> missionStats = missionStatsRepository.findMissionStatsByMissionIdIs(missionId);
        List<Integer> helldiversIds = missionStats.stream().map(t-> t.getHelldiver().getHelldiverId()).toList();

        List<Helldiver> helldivers = helldiverRepository.findAllById(helldiversIds);

        for(Helldiver hell : helldivers){
            MissionStats stats = missionStats.stream()
                    .filter(s -> s.getHelldiver().getHelldiverId().equals(hell.getHelldiverId()))
                    .findFirst()
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Stats not found"));

            if (stats.getKills() != null) hell.setKillsTotal(hell.getKillsTotal() + stats.getKills());
            if (stats.getDeaths() != null) hell.setDeathsTotal(hell.getDeathsTotal() + stats.getDeaths());
            hell.setMissionsCompleted(hell.getMissionsCompleted() + 1);
        }

        helldiverRepository.saveAll(helldivers);

        mission.setMissioStatsSaved(true);

        missionRepository.save(mission);

        return Map.of(
                "message", "Stats saved succesfully"
        );
    }
}
