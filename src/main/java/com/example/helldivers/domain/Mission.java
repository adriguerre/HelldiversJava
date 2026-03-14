package com.example.helldivers.domain;

import com.example.helldivers.enums.FactionType;
import com.example.helldivers.enums.MissionType;
import com.example.helldivers.enums.ResultType;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class Mission {

    @Id
    private Integer mission_id;
    private Integer planet_id;
    private Integer squad_id;
    private MissionType mission_type;
    private Integer difficulty;
    private FactionType enemy_faction;
    private Timestamp started_at;
    private Timestamp ended_at;
    private ResultType mission_result;
    private Integer samples_tier_1_found;
    private Integer samples_tier_2_found;
    private Integer samples_tier_3_found;
    private Integer xp_earned;
    private Integer medals_earned;


    public Mission() {}

    public Mission(Integer mission_id, Integer planet_id, Integer squad_id, MissionType mission_type,
                   Integer difficulty, FactionType enemy_faction, Timestamp started_at, Timestamp ended_at,
                   ResultType mission_result, Integer samples_tier_1_found, Integer samples_tier_2_found,
                   Integer samples_tier_3_found, Integer xp_earned, Integer medals_earned) {
        this.mission_id = mission_id;
        this.planet_id = planet_id;
        this.squad_id = squad_id;
        this.mission_type = mission_type;
        this.difficulty = difficulty;
        this.enemy_faction = enemy_faction;
        this.started_at = started_at;
        this.ended_at = ended_at;
        this.mission_result = mission_result;
        this.samples_tier_1_found = samples_tier_1_found;
        this.samples_tier_2_found = samples_tier_2_found;
        this.samples_tier_3_found = samples_tier_3_found;
        this.xp_earned = xp_earned;
        this.medals_earned = medals_earned;
    }

    public Integer getMission_id() {
        return mission_id;
    }

    public void setMission_id(Integer mission_id) {
        this.mission_id = mission_id;
    }

    public Integer getPlanet_id() {
        return planet_id;
    }

    public void setPlanet_id(Integer planet_id) {
        this.planet_id = planet_id;
    }

    public Integer getSquad_id() {
        return squad_id;
    }

    public void setSquad_id(Integer squad_id) {
        this.squad_id = squad_id;
    }

    public MissionType getMission_type() {
        return mission_type;
    }

    public void setMission_type(MissionType mission_type) {
        this.mission_type = mission_type;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public FactionType getEnemy_faction() {
        return enemy_faction;
    }

    public void setEnemy_faction(FactionType enemy_faction) {
        this.enemy_faction = enemy_faction;
    }

    public Timestamp getStarted_at() {
        return started_at;
    }

    public void setStarted_at(Timestamp started_at) {
        this.started_at = started_at;
    }

    public Timestamp getEnded_at() {
        return ended_at;
    }

    public void setEnded_at(Timestamp ended_at) {
        this.ended_at = ended_at;
    }

    public ResultType getMission_result() {
        return mission_result;
    }

    public void setMission_result(ResultType mission_result) {
        this.mission_result = mission_result;
    }

    public Integer getSamples_tier_1_found() {
        return samples_tier_1_found;
    }

    public void setSamples_tier_1_found(Integer samples_tier_1_found) {
        this.samples_tier_1_found = samples_tier_1_found;
    }

    public Integer getSamples_tier_2_found() {
        return samples_tier_2_found;
    }

    public void setSamples_tier_2_found(Integer samples_tier_2_found) {
        this.samples_tier_2_found = samples_tier_2_found;
    }

    public Integer getSamples_tier_3_found() {
        return samples_tier_3_found;
    }

    public void setSamples_tier_3_found(Integer samples_tier_3_found) {
        this.samples_tier_3_found = samples_tier_3_found;
    }

    public Integer getXp_earned() {
        return xp_earned;
    }

    public void setXp_earned(Integer xp_earned) {
        this.xp_earned = xp_earned;
    }

    public Integer getMedals_earned() {
        return medals_earned;
    }

    public void setMedals_earned(Integer medals_earned) {
        this.medals_earned = medals_earned;
    }
}
