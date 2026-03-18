package com.example.helldivers.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="mission_stats")
public class MissionStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stat_id")
    private Integer statId;
    @Column(name = "mission_id")
    private Integer missionId;
    @ManyToOne
    @JoinColumn(name="helldiver_id")
    @JsonProperty("helldiver")
    private Helldiver helldiver;
    private Integer kills;
    private Integer deaths;
    @Column(name = "friendly_kills")
    private Integer friendlyKills;
    @Column(name = "shots_fired")
    private Integer shotsFired;
    @Column(name = "accuracy_pct")
    private Double accuracyPct;
    @Column(name = "stratagems_used")
    private Integer stratagemsUsed;
    @Column(name = "distance_travelled")
    private Double distanceTravelled;
    @Column(name = "objectives_done")
    private Integer objectivesDone;


    public MissionStats() {
    }

    public MissionStats(Integer statId, Integer missionId, Helldiver helldiver, Integer kills, Integer deaths,
                        Integer friendlyKills, Integer shotsFired, Double accuracyPct, Integer stratagemsUsed,
                        Double distanceTravelled, Integer objectivesDone) {
        this.statId = statId;
        this.missionId = missionId;
        this.helldiver = helldiver;
        this.kills = kills;
        this.deaths = deaths;
        this.friendlyKills = friendlyKills;
        this.shotsFired = shotsFired;
        this.accuracyPct = accuracyPct;
        this.stratagemsUsed = stratagemsUsed;
        this.distanceTravelled = distanceTravelled;
        this.objectivesDone = objectivesDone;
    }

    public Integer getStatId() {
        return statId;
    }

    public void setStatId(Integer stat_id) {
        this.statId = stat_id;
    }

    public Integer getMissionId() {
        return missionId;
    }

    public void setMissionId(Integer mission_id) {
        this.missionId = mission_id;
    }

    public Helldiver getHelldiver() {
        return helldiver;
    }

    public void setHelldiver(Helldiver helldiver_id) {
        this.helldiver = helldiver;
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

    public Integer getFriendlyKills() {
        return friendlyKills;
    }

    public void setFriendlyKills(Integer friendly_kills) {
        this.friendlyKills = friendly_kills;
    }

    public Integer getShotsFired() {
        return shotsFired;
    }

    public void setShotsFired(Integer shots_fired) {
        this.shotsFired = shots_fired;
    }

    public Double getAccuracyPct() {
        return accuracyPct;
    }

    public void setAccuracyPct(Double accuracy_pct) {
        this.accuracyPct = accuracy_pct;
    }

    public Integer getStratagemsUsed() {
        return stratagemsUsed;
    }

    public void setStratagemsUsed(Integer stratagems_used) {
        this.stratagemsUsed = stratagems_used;
    }

    public Double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(Double distance_travelled) {
        this.distanceTravelled = distance_travelled;
    }

    public Integer getObjectivesDone() {
        return objectivesDone;
    }

    public void setObjectivesDone(Integer objectives_done) {
        this.objectivesDone = objectives_done;
    }
}
