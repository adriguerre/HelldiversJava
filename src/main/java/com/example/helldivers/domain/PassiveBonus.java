package com.example.helldivers.domain;

import jakarta.persistence.*;

@Entity
@Table(name="passive_bonus")
public class PassiveBonus {

    @Id
    @GeneratedValue
    @Column(name = "passive_id")
    private Integer passiveId;
    private String name;
    private String description;
    @Column(name = "stat_modifier")
    private String statModifier;


    public PassiveBonus() {
    }

    public PassiveBonus(Integer passiveId, String name, String description, String statModifier) {
        this.passiveId = passiveId;
        this.name = name;
        this.description = description;
        this.statModifier = statModifier;
    }

    public Integer getPassiveId() {
        return passiveId;
    }

    public void setPassiveId(Integer passive_id) {
        this.passiveId = passive_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatModifier() {
        return statModifier;
    }

    public void setStatModifier(String stat_modifier) {
        this.statModifier = stat_modifier;
    }
}
