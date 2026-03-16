package com.example.helldivers.domain;

import jakarta.persistence.*;

@Entity
@Table(name="mission_stats")
public class MissionStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stat_id;
    private Integer mission_id;
    private Integer helldiver_id;
    private Integer kills;
    private Integer deaths;
    private Integer friendly_kills;
    private Integer shots_fired;
    private Double accuracy_pct;
    private Integer stratagems_used;
    private Double distance_travelled;
    private Integer objectives_done;


    public MissionStats() {
    }

    public MissionStats(Integer stat_id, Integer mission_id, Integer helldiver_id, Integer kills, Integer deaths,
                        Integer friendly_kills, Integer shots_fired, Double accuracy_pct, Integer stratagems_used,
                        Double distance_travelled, Integer objectives_done) {
        this.stat_id = stat_id;
        this.mission_id = mission_id;
        this.helldiver_id = helldiver_id;
        this.kills = kills;
        this.deaths = deaths;
        this.friendly_kills = friendly_kills;
        this.shots_fired = shots_fired;
        this.accuracy_pct = accuracy_pct;
        this.stratagems_used = stratagems_used;
        this.distance_travelled = distance_travelled;
        this.objectives_done = objectives_done;
    }

    public Integer getStat_id() {
        return stat_id;
    }

    public void setStat_id(Integer stat_id) {
        this.stat_id = stat_id;
    }

    public Integer getMission_id() {
        return mission_id;
    }

    public void setMission_id(Integer mission_id) {
        this.mission_id = mission_id;
    }

    public Integer getHelldiver_id() {
        return helldiver_id;
    }

    public void setHelldiver_id(Integer helldiver_id) {
        this.helldiver_id = helldiver_id;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getFriendly_kills() {
        return friendly_kills;
    }

    public void setFriendly_kills(Integer friendly_kills) {
        this.friendly_kills = friendly_kills;
    }

    public Integer getShots_fired() {
        return shots_fired;
    }

    public void setShots_fired(Integer shots_fired) {
        this.shots_fired = shots_fired;
    }

    public Double getAccuracy_pct() {
        return accuracy_pct;
    }

    public void setAccuracy_pct(Double accuracy_pct) {
        this.accuracy_pct = accuracy_pct;
    }

    public Integer getStratagems_used() {
        return stratagems_used;
    }

    public void setStratagems_used(Integer stratagems_used) {
        this.stratagems_used = stratagems_used;
    }

    public Double getDistance_travelled() {
        return distance_travelled;
    }

    public void setDistance_travelled(Double distance_travelled) {
        this.distance_travelled = distance_travelled;
    }

    public Integer getObjectives_done() {
        return objectives_done;
    }

    public void setObjectives_done(Integer objectives_done) {
        this.objectives_done = objectives_done;
    }
}
