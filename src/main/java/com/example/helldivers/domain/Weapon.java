package com.example.helldivers.domain;

import com.example.helldivers.enums.WeaponType;
import jakarta.persistence.*;

@Entity
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weapon_id")
    private Integer weaponId;
    private String name;
    private Double damage;
    @Column(name = "fire_rate")
    private Double fireRate;
    @Column(name = "mag_size")
    private Short magSize;
    @Column(name = "max_ammo")
    private Short maxAmmo;
    private Double recoil;
    @Column(name = "penetration_level")
    private Integer penetrationLevel;
    @Column(name = "unlock_level")
    private Integer unlockLevel;
    @Column(name = "req_cost")
    private Integer reqCost;
    @Column(name = "image_url")
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    @Column(name = "weapon_type")
    private WeaponType weaponType;
    @Column(name = "super_credits_cost")
    private Integer superCreditsCost;

    public Weapon() {
    }

    public Weapon(Integer weaponId, String name, Double damage, Double fireRate, Short magSize, Short maxAmmo,
                  Double recoil, Integer penetrationLevel, Integer unlockLevel, Integer reqCost, String imageUrl,
                  WeaponType weaponType, Integer superCreditsCost) {
        this.weaponId = weaponId;
        this.name = name;
        this.damage = damage;
        this.fireRate = fireRate;
        this.magSize = magSize;
        this.maxAmmo = maxAmmo;
        this.recoil = recoil;
        this.penetrationLevel = penetrationLevel;
        this.unlockLevel = unlockLevel;
        this.reqCost = reqCost;
        this.imageUrl = imageUrl;
        this.weaponType = weaponType;
        superCreditsCost = superCreditsCost;
    }

    public Integer getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(Integer weapon_id) {
        this.weaponId = weapon_id;
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

    public Double getFireRate() {
        return fireRate;
    }

    public void setFireRate(Double fire_rate) {
        this.fireRate = fire_rate;
    }

    public Short getMagSize() {
        return magSize;
    }

    public void setMagSize(Short mag_size) {
        this.magSize = mag_size;
    }

    public Short getMaxAmmo() {
        return maxAmmo;
    }

    public void setMaxAmmo(Short max_ammo) {
        this.maxAmmo = max_ammo;
    }

    public Double getRecoil() {
        return recoil;
    }

    public void setRecoil(Double recoil) {
        this.recoil = recoil;
    }

    public Integer getPenetrationLevel() {
        return penetrationLevel;
    }

    public void setPenetrationLevel(Integer penetration_level) {
        this.penetrationLevel = penetration_level;
    }

    public Integer getUnlockLevel() {
        return unlockLevel;
    }

    public void setUnlockLevel(Integer unlock_level) {
        this.unlockLevel = unlock_level;
    }

    public Integer getReqCost() {
        return reqCost;
    }

    public void setReqCost(Integer req_cost) {
        this.reqCost = req_cost;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String image_url) {
        this.imageUrl = image_url;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weapon_type) {
        this.weaponType = weapon_type;
    }

    public Integer getSuperCreditsCost() {
        return superCreditsCost;
    }

    public void setSuperCreditsCost(Integer super_credits_cost) {
        this.superCreditsCost = super_credits_cost;
    }
}
