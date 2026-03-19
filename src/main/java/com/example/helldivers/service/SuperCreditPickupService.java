package com.example.helldivers.service;

import com.example.helldivers.domain.Account;
import com.example.helldivers.domain.Helldiver;
import com.example.helldivers.domain.Mission;
import com.example.helldivers.domain.SuperCreditPickup;
import com.example.helldivers.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Component
public class SuperCreditPickupService {

    private final SuperCreditPickupRepository pickupRepository;
    private final MissionRepository missionRepository;
    private final SquadMemberRepository squadMemberRepository;
    private final HelldiverRepository helldiverRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public SuperCreditPickupService(SuperCreditPickupRepository pickupRepository,
                                    MissionRepository missionRepository,
                                    SquadMemberRepository squadMemberRepository,
                                    HelldiverRepository helldiverRepository,
                                    AccountRepository accountRepository) {
        this.pickupRepository = pickupRepository;
        this.missionRepository = missionRepository;
        this.squadMemberRepository = squadMemberRepository;
        this.helldiverRepository = helldiverRepository;
        this.accountRepository = accountRepository;
    }

    public Map<String, Object> collectPickup(Integer missionId, Integer pickupId, String email) {
        // 1. Resolve account and helldiver from JWT email
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Account not found"));

        Helldiver helldiver = helldiverRepository.findByAccount(account)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No helldiver linked to this account"));
        System.out.println(">>> HELLDIVER FOUND: " + helldiver.getHelldiverId());

        // 2. Find mission
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mission not found"));
        System.out.println(">>> MISSION FOUND: " + mission.getMissionId() + " | started=" + mission.getStartedAt() + " | ended=" + mission.getEndedAt());

        // 3. Validate mission is still in progress
        if (mission.getStartedAt() == null || mission.getEndedAt() != null)
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Mission is not in progress");
        System.out.println(">>> MISSION IN PROGRESS: OK");

        // 5. Validate helldiver is a member of the mission's squad
        System.out.println(">>> SQUAD ID: " + mission.getSquadId() + " | HELLDIVER ID: " + helldiver.getHelldiverId());
        boolean isInSquad = squadMemberRepository.existsBySquadIdAndHelldiversId(
                mission.getSquadId(), helldiver.getHelldiverId());
        System.out.println(">>> IS IN SQUAD: " + isInSquad);
        if (!isInSquad)
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Your helldiver is not part of this mission");

        // 6. Find pickup in this mission
        SuperCreditPickup pickup = pickupRepository.findByPickupIdAndMissionId(pickupId, missionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pickup not found in this mission"));

        // 7. Check it hasn't been collected already
        if (Boolean.TRUE.equals(pickup.isCollected()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This pickup has already been collected");

        // 8. Collect
        pickup.setCollected(true);
        pickup.setCollectedByHelldiverId(helldiver.getHelldiverId());
        pickup.setCollectedAt(new Timestamp(System.currentTimeMillis()));
        pickupRepository.save(pickup);

        // 9. Give credits to all squad members
        List<Integer> squadMemberIds = squadMemberRepository.findBySquadId(mission.getSquadId())
                .stream().map(m -> m.getHelldiversId()).toList();

        List<Helldiver> squadHelldivers = helldiverRepository.findAllById(squadMemberIds);
        for (Helldiver member : squadHelldivers) {
            member.setSuperCredits(member.getSuperCredits() + pickup.getAmount());
        }
        helldiverRepository.saveAll(squadHelldivers);

        int collectorTotal = squadHelldivers.stream()
                .filter(h -> h.getHelldiverId().equals(helldiver.getHelldiverId()))
                .findFirst()
                .map(Helldiver::getSuperCredits)
                .orElse(helldiver.getSuperCredits());

        return Map.of(
                "message", "Super credits collected and distributed to squad",
                "amount", pickup.getAmount(),
                "total_super_credits", collectorTotal
        );
    }
}
