package com.example.helldivers.domain;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Helldiver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer helldiver_id;

    private Integer account_id;
    private String callsign;
    private Integer level;
    private Integer xp_total;
    private Integer kills_total;
    private Integer deaths_total;
    private Integer super_credits;
    private Timestamp created_at;
    private Integer medals;
    private Integer missions_completed;
    private Integer samples_tier_1_collected;
    private Integer samples_tier_2_collected;
    private Integer samples_tier_3_collected;

    public Helldiver() {
    }

    public Integer getHelldiver_id() {
        return helldiver_id;
    }

    public void setHelldiver_id(Integer helldiver_id) {
        this.helldiver_id = helldiver_id;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getXp_total() {
        return xp_total;
    }

    public void setXp_total(Integer xp_total) {
        this.xp_total = xp_total;
    }

    public Integer getKills_total() {
        return kills_total;
    }

    public void setKills_total(Integer kills_total) {
        this.kills_total = kills_total;
    }

    public Integer getDeaths_total() {
        return deaths_total;
    }

    public void setDeaths_total(Integer deaths_total) {
        this.deaths_total = deaths_total;
    }

    public Integer getSuper_credits() {
        return super_credits;
    }

    public void setSuper_credits(Integer super_credits) {
        this.super_credits = super_credits;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Integer getMedals() {
        return medals;
    }

    public void setMedals(Integer medals) {
        this.medals = medals;
    }

    public Integer getMissions_completed() {
        return missions_completed;
    }

    public void setMissions_completed(Integer missions_completed) {
        this.missions_completed = missions_completed;
    }

    public Integer getSamples_tier_1_collected() {
        return samples_tier_1_collected;
    }

    public void setSamples_tier_1_collected(Integer samples_tier_1_collected) {
        this.samples_tier_1_collected = samples_tier_1_collected;
    }

    public Integer getSamples_tier_2_collected() {
        return samples_tier_2_collected;
    }

    public void setSamples_tier_2_collected(Integer samples_tier_2_collected) {
        this.samples_tier_2_collected = samples_tier_2_collected;
    }

    public Integer getSamples_tier_3_collected() {
        return samples_tier_3_collected;
    }

    public void setSamples_tier_3_collected(Integer samples_tier_3_collected) {
        this.samples_tier_3_collected = samples_tier_3_collected;
    }
}
