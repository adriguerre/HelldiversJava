package com.example.helldivers.domain;

import com.example.helldivers.enums.StratagemType;
import jakarta.persistence.*;

@Entity
public class Stratagem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stratagem_id;
    private String name;
    @Enumerated(EnumType.STRING)
    private StratagemType category;
    private String input_sequence;
    private Short user_per_mission;
    private Short cooldown_seconds;
    private Short activation_time;
    private Double damage;
    private Double radius;
    private Integer req_cost;
    private Integer unlock_level;
    private Boolean backpack_slot;

    public Stratagem() {}


    public Stratagem(Integer stratagem_id, String name, StratagemType category, String input_sequence,
                     Short user_per_mission, Short cooldown_seconds, Short activation_time, Double damage, Double radius, Integer req_cost, Integer unlock_level, Boolean backpack_slot) {
        this.stratagem_id = stratagem_id;
        this.name = name;
        this.category = category;
        this.input_sequence = input_sequence;
        this.user_per_mission = user_per_mission;
        this.cooldown_seconds = cooldown_seconds;
        this.activation_time = activation_time;
        this.damage = damage;
        this.radius = radius;
        this.req_cost = req_cost;
        this.unlock_level = unlock_level;
        this.backpack_slot = backpack_slot;
    }

    public Integer getStratagem_id() { return stratagem_id; }
    public void setStratagem_id(Integer stratagem_id) { this.stratagem_id = stratagem_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public StratagemType getCategory() { return category; }
    public void setCategory(StratagemType category) { this.category = category; }
    public String getInput_sequence() { return input_sequence; }
    public void setInput_sequence(String input_sequence) { this.input_sequence = input_sequence; }
    public Short getUser_per_mission() { return user_per_mission; }
    public void setUser_per_mission(Short user_per_mission) { this.user_per_mission = user_per_mission; }
    public Short getCooldown_seconds() { return cooldown_seconds; }
    public void setCooldown_seconds(Short cooldown_seconds) { this.cooldown_seconds = cooldown_seconds; }
    public Short getActivation_time() { return activation_time; }
    public void setActivation_time(Short activation_time) { this.activation_time = activation_time; }
    public Double getDamage() { return damage; }
    public void setDamage(Double damage) { this.damage = damage; }
    public Double getRadius() { return radius; }
    public void setRadius(Double radius) { this.radius = radius; }
    public Integer getReq_cost() { return req_cost; }
    public void setReq_cost(Integer req_cost) { this.req_cost = req_cost; }
    public Integer getUnlock_level() { return unlock_level; }
    public void setUnlock_level(Integer unlock_level) { this.unlock_level = unlock_level; }
    public Boolean getBackpack_slot() { return backpack_slot; }
    public void setBackpack_slot(Boolean backpack_slot) { this.backpack_slot = backpack_slot; }
}