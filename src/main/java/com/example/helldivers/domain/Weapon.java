package com.example.helldivers.domain;

import com.example.helldivers.enums.WeaponType;
import jakarta.persistence.*;

@Entity
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer weapon_id;
    private String name;
    private Double damage;
    private Double fire_rate;
    private Short mag_size;
    private Short max_ammo;
    private Double recoil;
    private Integer penetration_level;
    private Integer unlock_level;
    private Integer req_cost;
    private String image_url;
    @Enumerated(EnumType.STRING)
    private WeaponType weapon_type;
    private Integer super_credits_cost;

    public Weapon() {
    }

    public Weapon(Integer weapon_id, String name, Double damage, Double fire_rate, Short mag_size, Short max_ammo,
                  Double recoil, Integer penetration_level, Integer unlock_level, Integer req_cost, String image_url,
                  WeaponType weapon_type, Integer superCreditsCost) {
        this.weapon_id = weapon_id;
        this.name = name;
        this.damage = damage;
        this.fire_rate = fire_rate;
        this.mag_size = mag_size;
        this.max_ammo = max_ammo;
        this.recoil = recoil;
        this.penetration_level = penetration_level;
        this.unlock_level = unlock_level;
        this.req_cost = req_cost;
        this.image_url = image_url;
        this.weapon_type = weapon_type;
        super_credits_cost = superCreditsCost;
    }

    public Integer getWeapon_id() {
        return weapon_id;
    }

    public void setWeapon_id(Integer weapon_id) {
        this.weapon_id = weapon_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDamage() {
        return damage;
    }

    public void setDamage(Double damage) {
        this.damage = damage;
    }

    public Double getFire_rate() {
        return fire_rate;
    }

    public void setFire_rate(Double fire_rate) {
        this.fire_rate = fire_rate;
    }

    public Short getMag_size() {
        return mag_size;
    }

    public void setMag_size(Short mag_size) {
        this.mag_size = mag_size;
    }

    public Short getMax_ammo() {
        return max_ammo;
    }

    public void setMax_ammo(Short max_ammo) {
        this.max_ammo = max_ammo;
    }

    public Double getRecoil() {
        return recoil;
    }

    public void setRecoil(Double recoil) {
        this.recoil = recoil;
    }

    public Integer getPenetration_level() {
        return penetration_level;
    }

    public void setPenetration_level(Integer penetration_level) {
        this.penetration_level = penetration_level;
    }

    public Integer getUnlock_level() {
        return unlock_level;
    }

    public void setUnlock_level(Integer unlock_level) {
        this.unlock_level = unlock_level;
    }

    public Integer getReq_cost() {
        return req_cost;
    }

    public void setReq_cost(Integer req_cost) {
        this.req_cost = req_cost;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public WeaponType getWeapon_type() {
        return weapon_type;
    }

    public void setWeapon_type(WeaponType weapon_type) {
        this.weapon_type = weapon_type;
    }

    public Integer getSuper_credits_cost() {
        return super_credits_cost;
    }

    public void setSuper_credits_cost(Integer super_credits_cost) {
        this.super_credits_cost = super_credits_cost;
    }
}
