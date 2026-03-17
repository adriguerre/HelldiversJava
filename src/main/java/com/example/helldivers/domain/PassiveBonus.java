package com.example.helldivers.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="passive_bonus")
public class PassiveBonus {

    @Id
    @GeneratedValue
    private Integer passive_id;
    private String name;
    private String description;
    private String stat_modifier;


    public PassiveBonus() {
    }

    public PassiveBonus(Integer passive_id, String name, String description, String stat_modifier) {
        this.passive_id = passive_id;
        this.name = name;
        this.description = description;
        this.stat_modifier = stat_modifier;
    }

    public Integer getPassive_id() {
        return passive_id;
    }

    public void setPassive_id(Integer passive_id) {
        this.passive_id = passive_id;
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

    public String getStat_modifier() {
        return stat_modifier;
    }

    public void setStat_modifier(String stat_modifier) {
        this.stat_modifier = stat_modifier;
    }
}
