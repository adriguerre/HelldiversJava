package com.example.helldivers.dto;

import com.example.helldivers.domain.PassiveBonus;
import com.example.helldivers.enums.ArmorSlot;

public class ArmorDTO {

    private Integer armor_id;
    private String name;
    private ArmorSlot armor_slot;
    private Integer armor_rating;
    private Integer speed;
    private Integer staming_regen;
    private Integer req_cost;
    private Integer super_credits_cost;
    private PassiveBonus passive;

    public ArmorDTO() {}

    public Integer getArmor_id() { return armor_id; }
    public void setArmor_id(Integer armor_id) { this.armor_id = armor_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public ArmorSlot getArmor_slot() { return armor_slot; }
    public void setArmor_slot(ArmorSlot armor_slot) { this.armor_slot = armor_slot; }
    public Integer getArmor_rating() { return armor_rating; }
    public void setArmor_rating(Integer armor_rating) { this.armor_rating = armor_rating; }
    public Integer getSpeed() { return speed; }
    public void setSpeed(Integer speed) { this.speed = speed; }
    public Integer getStaming_regen() { return staming_regen; }
    public void setStaming_regen(Integer staming_regen) { this.staming_regen = staming_regen; }
    public Integer getReq_cost() { return req_cost; }
    public void setReq_cost(Integer req_cost) { this.req_cost = req_cost; }
    public Integer getSuper_credits_cost() { return super_credits_cost; }
    public void setSuper_credits_cost(Integer super_credits_cost) { this.super_credits_cost = super_credits_cost; }
    public PassiveBonus getPassive() { return passive; }
    public void setPassive(PassiveBonus passive) { this.passive = passive; }
}