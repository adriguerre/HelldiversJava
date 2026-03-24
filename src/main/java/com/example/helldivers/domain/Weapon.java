package com.example.helldivers.domain;

import com.example.helldivers.enums.WeaponType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@JsonPropertyOrder({
        "weapon_id", "name", "weapon_type", "mag_size", "max_ammo", "recoil",
        "horizontal_recoil", "vertical_recoil", "spread_horizontal", "spread_vertical",
        "sway", "fire_rate", "ergonomics", "spare_magazines", "starting_magazines",
        "mags_from_supply", "mags_from_ammo_box", "unlock_level", "req_cost",
        "super_credits_cost", "image_url", "ammo_types", "attachments"
})
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weapon_id")
    private Integer weaponId;

    private String name;

    @Column(name = "mag_size")
    private Integer magSize;

    @Column(name = "max_ammo")
    private Integer maxAmmo;

    private Double recoil;

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

    @Column(name = "fire_rate")
    private Double fireRate;

    @Column(name = "horizontal_recoil")
    private Double horizontalRecoil;

    @Column(name = "vertical_recoil")
    private Double verticalRecoil;

    @Column(name = "spread_horizontal")
    private Double spreadHorizontal;

    @Column(name = "spread_vertical")
    private Double spreadVertical;

    private Double sway;

    private Integer ergonomics;

    @Column(name = "spare_magazines")
    private Integer spareMagazines;

    @Column(name = "starting_magazines")
    private Integer startingMagazines;

    @Column(name = "mags_from_supply")
    private Integer magsFromSupply;

    @Column(name = "mags_from_ammo_box")
    private Integer magsFromAmmoBox;

    @ManyToMany
    @JoinTable(
            name = "weapon_ammo",
            joinColumns = @JoinColumn(name = "weapon_id"),
            inverseJoinColumns = @JoinColumn(name = "ammo_id")
    )
    @JsonProperty("ammo_types")
    @BatchSize(size = 25)
    private List<Ammo> ammoTypes;

    @OneToMany(mappedBy = "weapon")
    @BatchSize(size = 25)
    private List<WeaponAttachment> attachments;

    public Weapon() {
    }

    public Integer getWeaponId() { return weaponId; }
    public void setWeaponId(Integer weaponId) { this.weaponId = weaponId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getMagSize() { return magSize; }
    public void setMagSize(Integer magSize) { this.magSize = magSize; }

    public Integer getMaxAmmo() { return maxAmmo; }
    public void setMaxAmmo(Integer maxAmmo) { this.maxAmmo = maxAmmo; }

    public Double getRecoil() { return recoil; }
    public void setRecoil(Double recoil) { this.recoil = recoil; }

    public Integer getUnlockLevel() { return unlockLevel; }
    public void setUnlockLevel(Integer unlockLevel) { this.unlockLevel = unlockLevel; }

    public Integer getReqCost() { return reqCost; }
    public void setReqCost(Integer reqCost) { this.reqCost = reqCost; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public WeaponType getWeaponType() { return weaponType; }
    public void setWeaponType(WeaponType weaponType) { this.weaponType = weaponType; }

    public Integer getSuperCreditsCost() { return superCreditsCost; }
    public void setSuperCreditsCost(Integer superCreditsCost) { this.superCreditsCost = superCreditsCost; }

    public Double getFireRate() { return fireRate; }
    public void setFireRate(Double fireRate) { this.fireRate = fireRate; }

    public Double getHorizontalRecoil() { return horizontalRecoil; }
    public void setHorizontalRecoil(Double horizontalRecoil) { this.horizontalRecoil = horizontalRecoil; }

    public Double getVerticalRecoil() { return verticalRecoil; }
    public void setVerticalRecoil(Double verticalRecoil) { this.verticalRecoil = verticalRecoil; }

    public Double getSpreadHorizontal() { return spreadHorizontal; }
    public void setSpreadHorizontal(Double spreadHorizontal) { this.spreadHorizontal = spreadHorizontal; }

    public Double getSpreadVertical() { return spreadVertical; }
    public void setSpreadVertical(Double spreadVertical) { this.spreadVertical = spreadVertical; }

    public Double getSway() { return sway; }
    public void setSway(Double sway) { this.sway = sway; }

    public Integer getErgonomics() { return ergonomics; }
    public void setErgonomics(Integer ergonomics) { this.ergonomics = ergonomics; }

    public Integer getSpareMagazines() { return spareMagazines; }
    public void setSpareMagazines(Integer spareMagazines) { this.spareMagazines = spareMagazines; }

    public Integer getStartingMagazines() { return startingMagazines; }
    public void setStartingMagazines(Integer startingMagazines) { this.startingMagazines = startingMagazines; }

    public Integer getMagsFromSupply() { return magsFromSupply; }
    public void setMagsFromSupply(Integer magsFromSupply) { this.magsFromSupply = magsFromSupply; }

    public Integer getMagsFromAmmoBox() { return magsFromAmmoBox; }
    public void setMagsFromAmmoBox(Integer magsFromAmmoBox) { this.magsFromAmmoBox = magsFromAmmoBox; }

    public List<Ammo> getAmmoTypes() { return ammoTypes; }
    public void setAmmoTypes(List<Ammo> ammoTypes) { this.ammoTypes = ammoTypes; }

    public List<WeaponAttachment> getAttachments() { return attachments; }
    public void setAttachments(List<WeaponAttachment> attachments) { this.attachments = attachments; }
}
