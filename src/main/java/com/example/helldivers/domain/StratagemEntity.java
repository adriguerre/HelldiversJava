package com.example.helldivers.domain;

import com.example.helldivers.domain.Stratagem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "stratagem_entity")
public class StratagemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_id")
    private Integer entityId;

    @OneToOne
    @JoinColumn(name = "stratagem_id")
    @JsonIgnore
    private Stratagem stratagem;

    @Column(name = "entity_name")
    private String entityName;

    @Column(name = "main_health")
    private Short mainHealth;

    @Column(name = "main_armor")
    private String mainArmor;

    @Column(name = "main_armor_level")
    private Short mainArmorLevel;

    @Column(name = "horizontal_turn_speed")
    private Short horizontalTurnSpeed;

    @Column(name = "vertical_turn_speed")
    private Short verticalTurnSpeed;

    @Column(name = "vertical_limit_min")
    private Double verticalLimitMin;

    @Column(name = "vertical_limit_max")
    private Double verticalLimitMax;

    @Column(name = "lifetime_secs")
    private Short lifetimeSecs;

    @Column(name = "mags_from_supply")
    private Short magsFromSupply;

    @Column(name = "mags_from_ammo_box")
    private Short magsFromAmmoBox;

    @Column(name = "max_rounds")
    private Short maxRounds;

    @Column(name = "starting_rounds")
    private Short startingRounds;

    @Column(name = "fire_rate_rpm")
    private Short fireRateRpm;

    private Double recoil;

    @Column(name = "horizontal_recoil")
    private Double horizontalRecoil;

    @Column(name = "vertical_recoil")
    private Double verticalRecoil;

    @Column(name = "spread_horizontal")
    private Double spreadHorizontal;

    @Column(name = "spread_vertical")
    private Double spreadVertical;

    private Double sway;
    private Short ergonomics;
    private Short capacity;

    public StratagemEntity() {}

    public StratagemEntity(Integer entityId, Stratagem stratagem, String entityName, Short mainHealth,
                           String mainArmor, Short mainArmorLevel, Short horizontalTurnSpeed, Short verticalTurnSpeed,
                           Double verticalLimitMin, Double verticalLimitMax, Short lifetimeSecs,
                           Short magsFromSupply, Short magsFromAmmoBox, Short maxRounds, Short startingRounds,
                           Short fireRateRpm, Double recoil, Double horizontalRecoil, Double verticalRecoil,
                           Double spreadHorizontal, Double spreadVertical, Double sway, Short ergonomics,
                           Short capacity) {
        this.entityId = entityId;
        this.stratagem = stratagem;
        this.entityName = entityName;
        this.mainHealth = mainHealth;
        this.mainArmor = mainArmor;
        this.mainArmorLevel = mainArmorLevel;
        this.horizontalTurnSpeed = horizontalTurnSpeed;
        this.verticalTurnSpeed = verticalTurnSpeed;
        this.verticalLimitMin = verticalLimitMin;
        this.verticalLimitMax = verticalLimitMax;
        this.lifetimeSecs = lifetimeSecs;
        this.magsFromSupply = magsFromSupply;
        this.magsFromAmmoBox = magsFromAmmoBox;
        this.maxRounds = maxRounds;
        this.startingRounds = startingRounds;
        this.fireRateRpm = fireRateRpm;
        this.recoil = recoil;
        this.horizontalRecoil = horizontalRecoil;
        this.verticalRecoil = verticalRecoil;
        this.spreadHorizontal = spreadHorizontal;
        this.spreadVertical = spreadVertical;
        this.sway = sway;
        this.ergonomics = ergonomics;
        this.capacity = capacity;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public Stratagem getStratagem() {
        return stratagem;
    }

    public void setStratagem(Stratagem stratagem) {
        this.stratagem = stratagem;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Short getMainHealth() {
        return mainHealth;
    }

    public void setMainHealth(Short mainHealth) {
        this.mainHealth = mainHealth;
    }

    public String getMainArmor() {
        return mainArmor;
    }

    public void setMainArmor(String mainArmor) {
        this.mainArmor = mainArmor;
    }

    public Short getMainArmorLevel() {
        return mainArmorLevel;
    }

    public void setMainArmorLevel(Short mainArmorLevel) {
        this.mainArmorLevel = mainArmorLevel;
    }

    public Short getHorizontalTurnSpeed() {
        return horizontalTurnSpeed;
    }

    public void setHorizontalTurnSpeed(Short horizontalTurnSpeed) {
        this.horizontalTurnSpeed = horizontalTurnSpeed;
    }

    public Short getVerticalTurnSpeed() {
        return verticalTurnSpeed;
    }

    public void setVerticalTurnSpeed(Short verticalTurnSpeed) {
        this.verticalTurnSpeed = verticalTurnSpeed;
    }

    public Double getVerticalLimitMin() {
        return verticalLimitMin;
    }

    public void setVerticalLimitMin(Double verticalLimitMin) {
        this.verticalLimitMin = verticalLimitMin;
    }

    public Double getVerticalLimitMax() {
        return verticalLimitMax;
    }

    public void setVerticalLimitMax(Double verticalLimitMax) {
        this.verticalLimitMax = verticalLimitMax;
    }

    public Short getLifetimeSecs() {
        return lifetimeSecs;
    }

    public void setLifetimeSecs(Short lifetimeSecs) {
        this.lifetimeSecs = lifetimeSecs;
    }

    public Short getMagsFromSupply() {
        return magsFromSupply;
    }

    public void setMagsFromSupply(Short magsFromSupply) {
        this.magsFromSupply = magsFromSupply;
    }

    public Short getMagsFromAmmoBox() {
        return magsFromAmmoBox;
    }

    public void setMagsFromAmmoBox(Short magsFromAmmoBox) {
        this.magsFromAmmoBox = magsFromAmmoBox;
    }

    public Short getMaxRounds() {
        return maxRounds;
    }

    public void setMaxRounds(Short maxRounds) {
        this.maxRounds = maxRounds;
    }

    public Short getStartingRounds() {
        return startingRounds;
    }

    public void setStartingRounds(Short startingRounds) {
        this.startingRounds = startingRounds;
    }

    public Short getFireRateRpm() {
        return fireRateRpm;
    }

    public void setFireRateRpm(Short fireRateRpm) {
        this.fireRateRpm = fireRateRpm;
    }

    public Double getRecoil() {
        return recoil;
    }

    public void setRecoil(Double recoil) {
        this.recoil = recoil;
    }

    public Double getHorizontalRecoil() {
        return horizontalRecoil;
    }

    public void setHorizontalRecoil(Double horizontalRecoil) {
        this.horizontalRecoil = horizontalRecoil;
    }

    public Double getVerticalRecoil() {
        return verticalRecoil;
    }

    public void setVerticalRecoil(Double verticalRecoil) {
        this.verticalRecoil = verticalRecoil;
    }

    public Double getSpreadHorizontal() {
        return spreadHorizontal;
    }

    public void setSpreadHorizontal(Double spreadHorizontal) {
        this.spreadHorizontal = spreadHorizontal;
    }

    public Double getSpreadVertical() {
        return spreadVertical;
    }

    public void setSpreadVertical(Double spreadVertical) {
        this.spreadVertical = spreadVertical;
    }

    public Double getSway() {
        return sway;
    }

    public void setSway(Double sway) {
        this.sway = sway;
    }

    public Short getErgonomics() {
        return ergonomics;
    }

    public void setErgonomics(Short ergonomics) {
        this.ergonomics = ergonomics;
    }

    public Short getCapacity() {
        return capacity;
    }

    public void setCapacity(Short capacity) {
        this.capacity = capacity;
    }
}