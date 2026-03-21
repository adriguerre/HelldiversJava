package com.example.helldivers.controllers;

import com.example.helldivers.service.MissionStatsService;
import com.example.helldivers.service.SuperCreditPickupService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missions")
public class MissionController {

    private final SuperCreditPickupService pickupService;

    public MissionController(SuperCreditPickupService pickupService) {
        this.pickupService = pickupService;
    }

    @PostMapping("/{missionId}/pickups/{pickupId}/collect")
    public ResponseEntity<?> collectPickup(@PathVariable Integer missionId,
                                           @PathVariable Integer pickupId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        return ResponseEntity.ok(pickupService.collectPickup(missionId, pickupId, email));
    }

}
