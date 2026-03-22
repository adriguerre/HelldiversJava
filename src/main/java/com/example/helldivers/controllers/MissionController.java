package com.example.helldivers.controllers;

import com.example.helldivers.domain.Mission;
import com.example.helldivers.enums.FactionType;
import com.example.helldivers.enums.MissionType;
import com.example.helldivers.enums.ResultType;
import com.example.helldivers.service.MissionService;
import com.example.helldivers.service.SuperCreditPickupService;
import com.example.helldivers.utils.UpdateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/missions")
public class MissionController {

    private final SuperCreditPickupService pickupService;
    private final MissionService missionService;

    public MissionController(SuperCreditPickupService pickupService, MissionService missionService) {
        this.pickupService = pickupService;
        this.missionService = missionService;
    }

    @GetMapping()
    public ResponseEntity<?> getMissions(@RequestParam(required = false) String missionType,
                                         @RequestParam(required = false) Integer difficulty,
                                         @RequestParam(required = false) String enemyFaction,
                                         @RequestParam(required = false) Boolean inProgress,
                                         @RequestParam(required = false) Boolean started,
                                         @RequestParam(required = false) Boolean ended,
                                         @RequestParam(required = false) String missionResult,
                                         @RequestParam(required = false) Boolean missionStatsSaved) {

        List<Mission> missions = missionService.getMissions(
                UpdateUtils.parseEnum(MissionType.class, missionType),
                difficulty,
                UpdateUtils.parseEnum(FactionType.class, enemyFaction),
                inProgress, started, ended,
                UpdateUtils.parseEnum(ResultType.class, missionResult),
                missionStatsSaved);

        if (missions.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "There are no missions with the specific filters"));

        return ResponseEntity.ok(missions);
    }

    @PostMapping("/{missionId}/pickups/{pickupId}/collect")
    public ResponseEntity<?> collectPickup(@PathVariable Integer missionId,
                                           @PathVariable Integer pickupId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        return ResponseEntity.ok(pickupService.collectPickup(missionId, pickupId, email));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMission(@RequestBody Mission mission){
        Boolean missionCreated = missionService.createMission(mission);

        if(missionCreated)
            return ResponseEntity.status(HttpStatus.CREATED).body(mission);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mission);
    }

    @GetMapping("{missionId}")
    public ResponseEntity<?> getMissionById(@PathVariable Integer missionId){
        Optional<Mission> mission = missionService.getMissionById(missionId);


        if(mission.isPresent())
            return ResponseEntity.ok(mission);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No mission found with ID [" + missionId + "]");
    }

    @DeleteMapping("{missionId}")
    public ResponseEntity<?> deleteMissionById(@PathVariable Integer missionId){
        Boolean missionDeleted = missionService.deleteMission(missionId);

        if(missionDeleted)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Mission with ID [" + missionId + "] deleted succesfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mission with ID [" + missionId + "] couldnt be deleted");
    }

    @PutMapping("/update/{missionId}")
    public ResponseEntity<?> updateMissionById(@PathVariable Integer missionId, @RequestBody Mission mission){
        return ResponseEntity.ok(missionService.updateMission(missionId, mission));
    }

}
