package com.example.helldivers.controllers;

import com.example.helldivers.service.MissionStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mstats")
public class MissionStatsController {

    private final MissionStatsService missionStatsService;

    @Autowired
    public MissionStatsController(MissionStatsService missionStatsService) {
        this.missionStatsService = missionStatsService;
    }

    @PostMapping("/{missionId}/saveStats")
    public ResponseEntity<?> saveStats(@PathVariable Integer missionId){
        return ResponseEntity.ok(missionStatsService.saveStats(missionId));

    }
}
