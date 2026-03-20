package com.example.helldivers.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Helldiver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "helldiver_id")
    private Integer helldiverId;
    @OneToOne
    @JoinColumn(name = "account_id")
    @JsonProperty("account")
    private Account account;
    @Column(name = "callsign")
    @JsonProperty("callsign")
    private String callSign;
    private Integer level = 1;
    @Column(name = "xp_total")
    private Integer xpTotal = 0;
    @Column(name = "kills_total")
    private Integer killsTotal = 0;
    @Column(name = "deaths_total")
    private Integer deathsTotal = 0;
    @Column(name = "super_credits")
    private Integer superCredits = 0;
    @Column(name = "created_at")
    private Timestamp createdAt;
    private Integer medals = 0;
    @Column(name = "missions_completed")
    private Integer missionsCompleted = 0;
    @Column(name = "samples_tier_1_collected")
    private Integer samplesTier1Collected = 0;
    @Column(name = "samples_tier_2_collected")
    private Integer samplesTier2Collected = 0;
    @Column(name = "samples_tier_3_collected")
    private Integer samplesTier3Collected = 0;
    @Column( name ="requisition_slips")
    private Integer requisitionSlips = 0;

    public Helldiver() {
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    public Integer getHelldiverId() {
        return helldiverId;
    }

    public void setHelldiverId(Integer helldiver_id) {
        this.helldiverId = helldiver_id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getXpTotal() {
        return xpTotal;
    }

    public void setXpTotal(Integer xp_total) {
        this.xpTotal = xp_total;
    }

    public Integer getKillsTotal() {
        return killsTotal;
    }

    public void setKillsTotal(Integer kills_total) {
        this.killsTotal = kills_total;
    }

    public Integer getDeathsTotal() {
        return deathsTotal;
    }

    public void setDeathsTotal(Integer deaths_total) {
        this.deathsTotal = deaths_total;
    }

    public Integer getSuperCredits() {
        return superCredits;
    }

    public void setSuperCredits(Integer super_credits) {
        this.superCredits = super_credits;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.createdAt = created_at;
    }

    public Integer getMedals() {
        return medals;
    }

    public void setMedals(Integer medals) {
        this.medals = medals;
    }

    public Integer getMissionsCompleted() {
        return missionsCompleted;
    }

    public void setMissionsCompleted(Integer missions_completed) {
        this.missionsCompleted = missions_completed;
    }

    public Integer getSamplesTier1Collected() {
        return samplesTier1Collected;
    }

    public void setSamplesTier1Collected(Integer samples_tier_1_collected) {
        this.samplesTier1Collected = samples_tier_1_collected;
    }

    public Integer getSamplesTier2Collected() {
        return samplesTier2Collected;
    }

    public void setSamplesTier2Collected(Integer samples_tier_2_collected) {
        this.samplesTier2Collected = samples_tier_2_collected;
    }

    public Integer getSamplesTier3Collected() {
        return samplesTier3Collected;
    }

    public void setSamplesTier3Collected(Integer samples_tier_3_collected) {
        this.samplesTier3Collected = samples_tier_3_collected;
    }

    public Integer getRequisitionSlips() {return requisitionSlips;}

    public void setRequisitionSlips(Integer requisitionSlips) {this.requisitionSlips = requisitionSlips;}
}
