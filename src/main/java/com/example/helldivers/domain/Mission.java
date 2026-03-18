package com.example.helldivers.domain;

import com.example.helldivers.enums.FactionType;
import com.example.helldivers.enums.MissionType;
import com.example.helldivers.enums.ResultType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")
    private Integer missionId;
    @ManyToOne
    @JoinColumn(name="planet_id")
    @JsonProperty("planet")
    private Planet planet;
    @Column(name = "squad_id")
    private Integer squadId;
    @Enumerated(EnumType.STRING)
    @Column(name = "mission_type")
    private MissionType missionType;
    private Integer difficulty;
    @Enumerated(EnumType.STRING)
    @Column(name = "enemy_faction")
    private FactionType enemyFaction;
    @Column(name = "started_at")
    private Timestamp startedAt;
    @Column(name = "ended_at")
    private Timestamp endedAt;
    @Enumerated(EnumType.STRING)
    @Column(name = "mission_result")
    private ResultType missionResult;
    @Column(name = "samples_tier_1_found")
    private Integer samplesTier1Found;
    @Column(name = "samples_tier_2_found")
    private Integer samplesTier2Found;
    @Column(name = "samples_tier_3_found")
    private Integer samplesTier3Found;
    @Column(name = "xp_earned")
    private Integer xpEarned;
    @Column(name = "medals_earned")
    private Integer medalsEarned;


    public Mission() {}

    public Mission(Integer missionId, Planet planet, Integer squadId, MissionType missionType,
                   Integer difficulty, FactionType enemyFaction, Timestamp startedAt, Timestamp endedAt,
                   ResultType missionResult, Integer samplesTier1Found, Integer samplesTier2Found,
                   Integer samplesTier3Found, Integer xpEarned, Integer medalsEarned) {
        this.missionId = missionId;
        this.planet= planet;
        this.squadId = squadId;
        this.missionType = missionType;
        this.difficulty = difficulty;
        this.enemyFaction = enemyFaction;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.missionResult = missionResult;
        this.samplesTier1Found = samplesTier1Found;
        this.samplesTier2Found = samplesTier2Found;
        this.samplesTier3Found = samplesTier3Found;
        this.xpEarned = xpEarned;
        this.medalsEarned = medalsEarned;
    }

    public Integer getMissionId() {
        return missionId;
    }

    public void setMissionId(Integer mission_id) {
        this.missionId = mission_id;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet_id(Planet planet) {
        this.planet = planet;
    }

    public Integer getSquadId() {
        return squadId;
    }

    public void setSquadId(Integer squad_id) {
        this.squadId = squad_id;
    }

    public MissionType getMissionType() {
        return missionType;
    }

    public void setMissionType(MissionType mission_type) {
        this.missionType = mission_type;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public FactionType getEnemyFaction() {
        return enemyFaction;
    }

    public void setEnemyFaction(FactionType enemy_faction) {
        this.enemyFaction = enemy_faction;
    }

    public Timestamp getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Timestamp started_at) {
        this.startedAt = started_at;
    }

    public Timestamp getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(Timestamp ended_at) {
        this.endedAt = ended_at;
    }

    public ResultType getMissionResult() {
        return missionResult;
    }

    public void setMissionResult(ResultType mission_result) {
        this.missionResult = mission_result;
    }

    public Integer getSamplesTier1Found() {
        return samplesTier1Found;
    }

    public void setSamplesTier1Found(Integer samples_tier_1_found) {
        this.samplesTier1Found = samples_tier_1_found;
    }

    public Integer getSamplesTier2Found() {
        return samplesTier2Found;
    }

    public void setSamplesTier2Found(Integer samples_tier_2_found) {
        this.samplesTier2Found = samples_tier_2_found;
    }

    public Integer getSamplesTier3Found() {
        return samplesTier3Found;
    }

    public void setSamplesTier3Found(Integer samples_tier_3_found) {
        this.samplesTier3Found = samples_tier_3_found;
    }

    public Integer getXpEarned() {
        return xpEarned;
    }

    public void setXpEarned(Integer xp_earned) {
        this.xpEarned = xp_earned;
    }

    public Integer getMedalsEarned() {
        return medalsEarned;
    }

    public void setMedalsEarned(Integer medals_earned) {
        this.medalsEarned = medals_earned;
    }
}
