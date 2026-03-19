package com.example.helldivers.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "super_credit_pickup")
public class SuperCreditPickup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pickup_id")
    private Integer pickupId;

    @Column(name = "mission_id")
    private Integer missionId;

    private Integer amount;

    private Boolean collected;

    @Column(name = "collected_by_helldiver_id")
    private Integer collectedByHelldiverId;

    @Column(name = "collected_at")
    private Timestamp collectedAt;

    public SuperCreditPickup() {}

    public Integer getPickupId() { return pickupId; }
    public void setPickupId(Integer pickupId) { this.pickupId = pickupId; }

    public Integer getMissionId() { return missionId; }
    public void setMissionId(Integer missionId) { this.missionId = missionId; }

    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }

    public Boolean isCollected() { return collected; }
    public void setCollected(Boolean collected) { this.collected = collected; }

    public Integer getCollectedByHelldiverId() { return collectedByHelldiverId; }
    public void setCollectedByHelldiverId(Integer collectedByHelldiverId) { this.collectedByHelldiverId = collectedByHelldiverId; }

    public Timestamp getCollectedAt() { return collectedAt; }
    public void setCollectedAt(Timestamp collectedAt) { this.collectedAt = collectedAt; }
}
