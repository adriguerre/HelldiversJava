package com.example.helldivers.domain;

import com.example.helldivers.enums.StratagemType;
import jakarta.persistence.*;

@Entity
public class Stratagem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stratagem_id")
    private Integer stratagemId;
    private String name;
    @Enumerated(EnumType.STRING)
    private StratagemType category;
    @Column(name="input_sequence")
    private String inputSequence;
    @Column(name="uses_per_mission")
    private Short usesPerMission;
    @Column(name="cooldown_seconds")
    private Short cooldownSeconds;
    @Column(name="activation_time")
    private Short activationTime;
    private Double damage;
    private Double radius;
    @Column(name="req_cost")
    private Integer reqCost;
    @Column(name="unlock_level")
    private Integer unlockLevel;
    @Column(name="backpack_slot")
    private Boolean backpackSlot;

    public Stratagem() {}


    public Stratagem(Integer stratagemId, String name, StratagemType category, String inputSequence,
                     Short userPerMission, Short cooldown_seconds, Short activationTime, Double damage, Double radius,
                     Integer reqCost, Integer unlockLevel, Boolean backpackSlot) {
        this.stratagemId = stratagemId;
        this.name = name;
        this.category = category;
        this.inputSequence = inputSequence;
        this.usesPerMission = userPerMission;
        this.cooldownSeconds = cooldown_seconds;
        this.activationTime = activationTime;
        this.damage = damage;
        this.radius = radius;
        this.reqCost = reqCost;
        this.unlockLevel = unlockLevel;
        this.backpackSlot = backpackSlot;
    }

    public Integer getStratagemId() { return stratagemId; }
    public void setStratagemId(Integer stratagem_id) { this.stratagemId = stratagem_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public StratagemType getCategory() { return category; }
    public void setCategory(StratagemType category) { this.category = category; }
    public String getInputSequence() { return inputSequence; }
    public void setInputSequence(String input_sequence) { this.inputSequence = input_sequence; }
    public Short getUsesPerMission() { return usesPerMission; }
    public void setUsesPerMission(Short user_per_mission) { this.usesPerMission = user_per_mission; }
    public Short getCooldownSeconds() { return cooldownSeconds; }
    public void setCooldownSeconds(Short cooldown_seconds) { this.cooldownSeconds = cooldown_seconds; }
    public Short getActivationTime() { return activationTime; }
    public void setActivationTime(Short activation_time) { this.activationTime = activation_time; }
    public Double getDamage() { return damage; }
    public void setDamage(Double damage) { this.damage = damage; }
    public Double getRadius() { return radius; }
    public void setRadius(Double radius) { this.radius = radius; }
    public Integer getReqCost() { return reqCost; }
    public void setReqCost(Integer req_cost) { this.reqCost = req_cost; }
    public Integer getUnlockLevel() { return unlockLevel; }
    public void setUnlockLevel(Integer unlockLevel) { this.unlockLevel = unlockLevel; }
    public Boolean getBackpackSlot() { return backpackSlot; }
    public void setBackpackSlot(Boolean backpack_slot) { this.backpackSlot = backpackSlot; }
}