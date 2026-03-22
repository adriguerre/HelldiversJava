package com.example.helldivers.service;

import com.example.helldivers.domain.Mission;
import com.example.helldivers.enums.FactionType;
import com.example.helldivers.enums.MissionType;
import com.example.helldivers.enums.ResultType;
import com.example.helldivers.repository.MissionRepository;
import com.example.helldivers.specification.MissionSpecification;
import com.example.helldivers.utils.UpdateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {


    private MissionRepository missionRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public MissionService(MissionRepository missionRepository){
        this.missionRepository = missionRepository;
    }

    public List<Mission> getMissions(MissionType missionType, Integer difficulty, FactionType enemyFaction, Boolean inProgress, Boolean started,
                                     Boolean ended, ResultType missionResult, Boolean missionStatsSaved){

        List<Mission> missions = missionRepository.findAll(MissionSpecification.withFilters(missionType,
                difficulty, enemyFaction, inProgress, started, ended, missionResult, missionStatsSaved));

        return missions;
    }

    public Optional<Mission> getMissionById(Integer missionId){
        return missionRepository.findById(missionId);
    }

    public Boolean createMission(Mission mission){
        try{
            missionRepository.save(mission);
        }
        catch(Exception ex){
            System.out.println("ERROR ON MISSION CREATION: " + ex.getMessage());
            return false;
        }

        return true;
    }

    public Boolean deleteMission(Integer missionId){
        try{
            missionRepository.deleteById(missionId);
        }
        catch(Exception ex){
            System.out.println("ERROR ON MISSION DELETION: " + ex.getMessage());
            return false;
        }
        return true;
    }

    @Transactional
    public Object updateMission(Integer missionId, Mission mission) {
        Mission db = missionRepository.findById(missionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Mission with ID [" + missionId + "] not found"));

        UpdateUtils.updateIfPresent(mission::getPlanet,            db::setPlanet);
        UpdateUtils.updateIfPresent(mission::getDifficulty,       db::setDifficulty);
        UpdateUtils.updateIfPresent(mission::getStartedAt,      db::setStartedAt);
        UpdateUtils.updateIfPresent(mission::getEndedAt, db::setEndedAt);
        UpdateUtils.updateIfPresent(mission::getMissionResult,  db::setMissionResult);
        UpdateUtils.updateIfPresent(mission::getSamplesTier1Found,  db::setSamplesTier1Found);
        UpdateUtils.updateIfPresent(mission::getSamplesTier2Found,  db::setSamplesTier2Found);
        UpdateUtils.updateIfPresent(mission::getSamplesTier3Found,  db::setSamplesTier3Found);
        UpdateUtils.updateIfPresent(mission::getXpEarned,  db::setXpEarned);
        UpdateUtils.updateIfPresent(mission::getMedalsEarned,  db::setMedalsEarned);
        UpdateUtils.updateIfPresent(mission::getMissionStatsSaved,  db::setMissionStatsSaved);

        missionRepository.save(db);
        entityManager.flush();
        entityManager.refresh(db);
        return db;
    }
}
