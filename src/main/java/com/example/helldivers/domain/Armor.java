package com.example.helldivers.domain;

import com.example.helldivers.enums.ArmorSlot;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Armor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "armor_id")
    private Integer armorId;
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "armor_slot")
    private ArmorSlot armorSlot;
    @Column(name = "armor_rating")
    private Integer armorRating;
    private Integer speed;
    @Column(name = "stamina_regen")
    private Integer staminaRegen;
    @ManyToOne
    @JoinColumn(name = "passive_id")
    @JsonProperty("passive")
    private PassiveBonus passive;
    @Column(name = "req_cost")
    private Integer reqCost;
    @Column(name = "super_credits_cost")
    private Integer superCreditsCost;


    public Armor() {
    }

    public Armor(Integer armorId, String name, ArmorSlot armor_slot, Integer armorRating, Integer speed,
                 Integer staminaRegen, PassiveBonus passive, Integer reqCost, Integer superCreditsCost) {
        this.armorId = armorId;
        this.name = name;
        this.armorSlot = armor_slot;
        this.armorRating = armorRating;
        this.speed = speed;
        this.staminaRegen = staminaRegen;
        this.passive = passive;
        this.reqCost = reqCost;
        this.superCreditsCost = superCreditsCost;
    }

    public Integer getArmorId() {
        return armorId;
    }

    public void setArmorId(Integer armor_id) {
        this.armorId = armor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArmorSlot getArmorSlot() {
        return armorSlot;
    }

    public void setArmorSlot(ArmorSlot armor_slot) {
        this.armorSlot = armor_slot;
    }

    public Integer getArmorRating() {
        return armorRating;
    }

    public void setArmorRating(Integer armor_rating) {
        this.armorRating = armor_rating;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getStaminaRegen() {
        return staminaRegen;
    }

    public void setStaminaRegen(Integer stamina_regen) {
        this.staminaRegen = stamina_regen;
    }

    public PassiveBonus getPassive() {return passive;}

    public void setPassive(PassiveBonus passive) {this.passive = passive;}

    public Integer getReqCost() {
        return reqCost;
    }

    public void setReqCost(Integer req_cost) {
        this.reqCost = req_cost;
    }

    public Integer getSuperCreditsCost() {
        return superCreditsCost;
    }

    public void setSuperCreditsCost(Integer super_credits_cost) {
        this.superCreditsCost = super_credits_cost;
    }
}
