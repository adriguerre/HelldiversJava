package com.example.helldivers.domain;

import com.example.helldivers.enums.ArmorSlot;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Armor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer armor_id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ArmorSlot armor_slot;
    private Integer armor_rating;
    private Integer speed;
    private Integer staming_regen;
    @ManyToOne
    @JoinColumn(name = "passive_id")
    @JsonProperty("passive")
    private PassiveBonus passive;
    private Integer req_cost;
    private Integer super_credits_cost;


    public Armor() {
    }

    public Armor(Integer armor_id, String name, ArmorSlot armor_slot, Integer armor_rating, Integer speed,
                 Integer staming_regen, PassiveBonus passive, Integer req_cost, Integer super_credits_cost) {
        this.armor_id = armor_id;
        this.name = name;
        this.armor_slot = armor_slot;
        this.armor_rating = armor_rating;
        this.speed = speed;
        this.staming_regen = staming_regen;
        this.passive = passive;
        this.req_cost = req_cost;
        this.super_credits_cost = super_credits_cost;
    }

    public Integer getArmor_id() {
        return armor_id;
    }

    public void setArmor_id(Integer armor_id) {
        this.armor_id = armor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArmorSlot getArmor_slot() {
        return armor_slot;
    }

    public void setArmor_slot(ArmorSlot armor_slot) {
        this.armor_slot = armor_slot;
    }

    public Integer getArmor_rating() {
        return armor_rating;
    }

    public void setArmor_rating(Integer armor_rating) {
        this.armor_rating = armor_rating;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getStaming_regen() {
        return staming_regen;
    }

    public void setStaming_regen(Integer staming_regen) {
        this.staming_regen = staming_regen;
    }

    public PassiveBonus getPassive_id() {
        return passive;
    }

    public void setPassive_id(PassiveBonus passive) {
        this.passive = passive;
    }

    public Integer getReq_cost() {
        return req_cost;
    }

    public void setReq_cost(Integer req_cost) {
        this.req_cost = req_cost;
    }

    public Integer getSuper_credits_cost() {
        return super_credits_cost;
    }

    public void setSuper_credits_cost(Integer super_credits_cost) {
        this.super_credits_cost = super_credits_cost;
    }
}
