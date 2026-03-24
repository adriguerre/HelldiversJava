package com.example.helldivers.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Table(name = "stratagem_attack")
public class StratagemAttack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attack_id")
    private Integer attackId;

    @ManyToOne
    @JoinColumn(name = "stratagem_id")
    @JsonIgnore
    private Stratagem stratagem;

    @Column(name = "attack_name")
    private String attackName;

    @Column(name = "attack_type")
    private String attackType;

    @Column(name = "sort_order")
    private Short sortOrder;

    @Column(name = "damage_element")
    private String damageElement;

    @Column(name = "damage_standard")
    private Double damageStandard;

    @Column(name = "damage_standard_type")
    private String damageStandardType;

    @Column(name = "damage_vs_durable")
    private Double damageVsDurable;

    @Column(name = "damage_vs_durable_type")
    private String damageVsDurableType;

    @Column(name = "inner_radius_m")
    private Double innerRadiusM;

    @Column(name = "outer_radius_m")
    private Double outerRadiusM;

    @Column(name = "shockwave_radius_m")
    private Double shockwaveRadiusM;

    @Column(name = "inner_damage")
    private Double innerDamage;

    @Column(name = "inner_damage_type")
    private String innerDamageType;

    @Column(name = "inner_durable")
    private Double innerDurable;

    @Column(name = "inner_durable_type")
    private String innerDurableType;

    @Column(name = "outer_damage")
    private Double outerDamage;

    @Column(name = "outer_durable")
    private Double outerDurable;

    @Column(name = "aoe_penetration_level")
    private Short aoePenetrationLevel;

    @Column(name = "aoe_penetration_name")
    private String aoePenetrationName;

    @Column(name = "penetration_direct")
    private Short penetrationDirect;

    @Column(name = "penetration_direct_name")
    private String penetrationDirectName;

    @Column(name = "penetration_slight_angle")
    private Short penetrationSlightAngle;

    @Column(name = "penetration_slight_name")
    private String penetrationSlightName;

    @Column(name = "penetration_large_angle")
    private Short penetrationLargeAngle;

    @Column(name = "penetration_large_name")
    private String penetrationLargeName;

    @Column(name = "penetration_extreme_angle")
    private Short penetrationExtremeAngle;

    @Column(name = "penetration_extreme_name")
    private String penetrationExtremeName;

    @Column(name = "projectile_name")
    private String projectileName;

    private String caliber;

    @Column(name = "mass_grams")
    private Double massGrams;

    @Column(name = "initial_velocity_ms")
    private Short initialVelocityMs;

    @Column(name = "drag_factor_pct")
    private Short dragFactorPct;

    @Column(name = "gravity_factor_pct")
    private Short gravityFactorPct;

    @Column(name = "penetration_slowdown_pct")
    private Short penetrationSlowdownPct;

    @Column(name = "demolition_force")
    private Short demolitionForce;

    @Column(name = "stagger_force")
    private Short staggerForce;

    @Column(name = "push_force")
    private Short pushForce;

    @OneToMany(mappedBy = "attack", cascade = CascadeType.ALL)
    @BatchSize(size = 25)
    private List<StratagemAttackStatus> status;

    public StratagemAttack() {}


    public Integer getAttackId() {
        return attackId;
    }

    public void setAttackId(Integer attackId) {
        this.attackId = attackId;
    }
    @JsonIgnore
    public Stratagem getStratagem() {
        return stratagem;
    }

    public void setStratagem(Stratagem stratagem) {
        this.stratagem = stratagem;
    }

    public String getAttackName() {
        return attackName;
    }

    public void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public Short getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Short sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getDamageElement() {
        return damageElement;
    }

    public void setDamageElement(String damageElement) {
        this.damageElement = damageElement;
    }

    public Double getDamageStandard() {
        return damageStandard;
    }

    public void setDamageStandard(Double damageStandard) {
        this.damageStandard = damageStandard;
    }

    public String getDamageStandardType() {
        return damageStandardType;
    }

    public void setDamageStandardType(String damageStandardType) {
        this.damageStandardType = damageStandardType;
    }

    public Double getDamageVsDurable() {
        return damageVsDurable;
    }

    public void setDamageVsDurable(Double damageVsDurable) {
        this.damageVsDurable = damageVsDurable;
    }

    public String getDamageVsDurableType() {
        return damageVsDurableType;
    }

    public void setDamageVsDurableType(String damageVsDurableType) {
        this.damageVsDurableType = damageVsDurableType;
    }

    public Double getInnerRadiusM() {
        return innerRadiusM;
    }

    public void setInnerRadiusM(Double innerRadiusM) {
        this.innerRadiusM = innerRadiusM;
    }

    public Double getOuterRadiusM() {
        return outerRadiusM;
    }

    public void setOuterRadiusM(Double outerRadiusM) {
        this.outerRadiusM = outerRadiusM;
    }

    public Double getShockwaveRadiusM() {
        return shockwaveRadiusM;
    }

    public void setShockwaveRadiusM(Double shockwaveRadiusM) {
        this.shockwaveRadiusM = shockwaveRadiusM;
    }

    public Double getInnerDamage() {
        return innerDamage;
    }

    public void setInnerDamage(Double innerDamage) {
        this.innerDamage = innerDamage;
    }

    public String getInnerDamageType() {
        return innerDamageType;
    }

    public void setInnerDamageType(String innerDamageType) {
        this.innerDamageType = innerDamageType;
    }

    public Double getInnerDurable() {
        return innerDurable;
    }

    public void setInnerDurable(Double innerDurable) {
        this.innerDurable = innerDurable;
    }

    public String getInnerDurableType() {
        return innerDurableType;
    }

    public void setInnerDurableType(String innerDurableType) {
        this.innerDurableType = innerDurableType;
    }

    public Double getOuterDamage() {
        return outerDamage;
    }

    public void setOuterDamage(Double outerDamage) {
        this.outerDamage = outerDamage;
    }

    public Double getOuterDurable() {
        return outerDurable;
    }

    public void setOuterDurable(Double outerDurable) {
        this.outerDurable = outerDurable;
    }

    public Short getAoePenetrationLevel() {
        return aoePenetrationLevel;
    }

    public void setAoePenetrationLevel(Short aoePenetrationLevel) {
        this.aoePenetrationLevel = aoePenetrationLevel;
    }

    public String getAoePenetrationName() {
        return aoePenetrationName;
    }

    public void setAoePenetrationName(String aoePenetrationName) {
        this.aoePenetrationName = aoePenetrationName;
    }

    public Short getPenetrationDirect() {
        return penetrationDirect;
    }

    public void setPenetrationDirect(Short penetrationDirect) {
        this.penetrationDirect = penetrationDirect;
    }

    public String getPenetrationDirectName() {
        return penetrationDirectName;
    }

    public void setPenetrationDirectName(String penetrationDirectName) {
        this.penetrationDirectName = penetrationDirectName;
    }

    public Short getPenetrationSlightAngle() {
        return penetrationSlightAngle;
    }

    public void setPenetrationSlightAngle(Short penetrationSlightAngle) {
        this.penetrationSlightAngle = penetrationSlightAngle;
    }

    public String getPenetrationSlightName() {
        return penetrationSlightName;
    }

    public void setPenetrationSlightName(String penetrationSlightName) {
        this.penetrationSlightName = penetrationSlightName;
    }

    public Short getPenetrationLargeAngle() {
        return penetrationLargeAngle;
    }

    public void setPenetrationLargeAngle(Short penetrationLargeAngle) {
        this.penetrationLargeAngle = penetrationLargeAngle;
    }

    public String getPenetrationLargeName() {
        return penetrationLargeName;
    }

    public void setPenetrationLargeName(String penetrationLargeName) {
        this.penetrationLargeName = penetrationLargeName;
    }

    public Short getPenetrationExtremeAngle() {
        return penetrationExtremeAngle;
    }

    public void setPenetrationExtremeAngle(Short penetrationExtremeAngle) {
        this.penetrationExtremeAngle = penetrationExtremeAngle;
    }

    public String getPenetrationExtremeName() {
        return penetrationExtremeName;
    }

    public void setPenetrationExtremeName(String penetrationExtremeName) {
        this.penetrationExtremeName = penetrationExtremeName;
    }

    public String getProjectileName() {
        return projectileName;
    }

    public void setProjectileName(String projectileName) {
        this.projectileName = projectileName;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public Double getMassGrams() {
        return massGrams;
    }

    public void setMassGrams(Double massGrams) {
        this.massGrams = massGrams;
    }

    public Short getInitialVelocityMs() {
        return initialVelocityMs;
    }

    public void setInitialVelocityMs(Short initialVelocityMs) {
        this.initialVelocityMs = initialVelocityMs;
    }

    public Short getDragFactorPct() {
        return dragFactorPct;
    }

    public void setDragFactorPct(Short dragFactorPct) {
        this.dragFactorPct = dragFactorPct;
    }

    public Short getGravityFactorPct() {
        return gravityFactorPct;
    }

    public void setGravityFactorPct(Short gravityFactorPct) {
        this.gravityFactorPct = gravityFactorPct;
    }

    public Short getPenetrationSlowdownPct() {
        return penetrationSlowdownPct;
    }

    public void setPenetrationSlowdownPct(Short penetrationSlowdownPct) {
        this.penetrationSlowdownPct = penetrationSlowdownPct;
    }

    public Short getDemolitionForce() {
        return demolitionForce;
    }

    public void setDemolitionForce(Short demolitionForce) {
        this.demolitionForce = demolitionForce;
    }

    public Short getStaggerForce() {
        return staggerForce;
    }

    public void setStaggerForce(Short staggerForce) {
        this.staggerForce = staggerForce;
    }

    public Short getPushForce() {
        return pushForce;
    }

    public void setPushForce(Short pushForce) {
        this.pushForce = pushForce;
    }

    public List<StratagemAttackStatus> getStatus() {
        return status;
    }

    public void setStatus(List<StratagemAttackStatus> statuses) {
        this.status = statuses;
    }
}