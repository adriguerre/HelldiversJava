package com.example.helldivers.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

@Entity
@JsonPropertyOrder({
        "ammo_id", "name", "caliber"
})
public class Ammo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ammo_id")
    private Integer ammoId;

    private String name;
    private String caliber;

    @Column(name = "mass_grams")
    private Double massGrams;

    @Column(name = "initial_velocity_ms")
    private Double initialVelocityMs;

    @Column(name = "drag_factor_pct")
    private Double dragFactorPct;

    @Column(name = "gravity_factor_pct")
    private Double gravityFactorPct;

    @Column(name = "penetration_slowdown_pct")
    private Double penetrationSlowdownPct;

    @Column(name = "damage_standard")
    private Integer damageStandard;

    @Column(name = "damage_standard_type")
    @JsonProperty("damage_standard_type")
    private String damageStandardType;

    @Column(name = "damage_durable")
    private Integer damageDurable;

    @Column(name = "damage_durable_type")
    @JsonProperty("damage_durable_type")
    private String damageDurableType;

    @Column(name = "penetration_direct")
    private Short penetrationDirect;

    @Column(name = "penetration_direct_name")
    @JsonProperty("penetration_direct_name")
    private String penetrationDirectName;

    @Column(name = "penetration_slight_angle")
    private Short penetrationSlightAngle;

    @Column(name = "penetration_slight_name")
    @JsonProperty("penetration_slight_name")
    private String penetrationSlightName;

    @Column(name = "penetration_large_angle")
    private Short penetrationLargeAngle;

    @Column(name = "penetration_large_name")
    @JsonProperty("penetration_large_name")
    private String penetrationLargeName;

    @Column(name = "penetration_extreme_angle")
    private Short penetrationExtremeAngle;

    @Column(name = "penetration_extreme_name")
    @JsonProperty("penetration_extreme_name")
    private String penetrationExtremeName;

    @Column(name = "demolition_force")
    private Short demolitionForce;

    @Column(name = "stagger_force")
    private Short staggerForce;

    @Column(name = "push_force")
    private Short pushForce;

    public Ammo() {
    }

    public Integer getAmmoId() { return ammoId; }
    public void setAmmoId(Integer ammoId) { this.ammoId = ammoId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCaliber() { return caliber; }
    public void setCaliber(String caliber) { this.caliber = caliber; }

    public Double getMassGrams() { return massGrams; }
    public void setMassGrams(Double massGrams) { this.massGrams = massGrams; }

    public Double getInitialVelocityMs() { return initialVelocityMs; }
    public void setInitialVelocityMs(Double initialVelocityMs) { this.initialVelocityMs = initialVelocityMs; }

    public Double getDragFactorPct() { return dragFactorPct; }
    public void setDragFactorPct(Double dragFactorPct) { this.dragFactorPct = dragFactorPct; }

    public Double getGravityFactorPct() { return gravityFactorPct; }
    public void setGravityFactorPct(Double gravityFactorPct) { this.gravityFactorPct = gravityFactorPct; }

    public Double getPenetrationSlowdownPct() { return penetrationSlowdownPct; }
    public void setPenetrationSlowdownPct(Double penetrationSlowdownPct) { this.penetrationSlowdownPct = penetrationSlowdownPct; }

    public Integer getDamageStandard() { return damageStandard; }
    public void setDamageStandard(Integer damageStandard) { this.damageStandard = damageStandard; }

    public String getDamageStandardType() { return damageStandardType; }
    public void setDamageStandardType(String damageStandardType) { this.damageStandardType = damageStandardType; }

    public Integer getDamageDurable() { return damageDurable; }
    public void setDamageDurable(Integer damageDurable) { this.damageDurable = damageDurable; }

    public String getDamageDurableType() { return damageDurableType; }
    public void setDamageDurableType(String damageDurableType) { this.damageDurableType = damageDurableType; }

    public Short getPenetrationDirect() { return penetrationDirect; }
    public void setPenetrationDirect(Short penetrationDirect) { this.penetrationDirect = penetrationDirect; }

    public String getPenetrationDirectName() { return penetrationDirectName; }
    public void setPenetrationDirectName(String penetrationDirectName) { this.penetrationDirectName = penetrationDirectName; }

    public Short getPenetrationSlightAngle() { return penetrationSlightAngle; }
    public void setPenetrationSlightAngle(Short penetrationSlightAngle) { this.penetrationSlightAngle = penetrationSlightAngle; }

    public String getPenetrationSlightName() { return penetrationSlightName; }
    public void setPenetrationSlightName(String penetrationSlightName) { this.penetrationSlightName = penetrationSlightName; }

    public Short getPenetrationLargeAngle() { return penetrationLargeAngle; }
    public void setPenetrationLargeAngle(Short penetrationLargeAngle) { this.penetrationLargeAngle = penetrationLargeAngle; }

    public String getPenetrationLargeName() { return penetrationLargeName; }
    public void setPenetrationLargeName(String penetrationLargeName) { this.penetrationLargeName = penetrationLargeName; }

    public Short getPenetrationExtremeAngle() { return penetrationExtremeAngle; }
    public void setPenetrationExtremeAngle(Short penetrationExtremeAngle) { this.penetrationExtremeAngle = penetrationExtremeAngle; }

    public String getPenetrationExtremeName() { return penetrationExtremeName; }
    public void setPenetrationExtremeName(String penetrationExtremeName) { this.penetrationExtremeName = penetrationExtremeName; }

    public Short getDemolitionForce() { return demolitionForce; }
    public void setDemolitionForce(Short demolitionForce) { this.demolitionForce = demolitionForce; }

    public Short getStaggerForce() { return staggerForce; }
    public void setStaggerForce(Short staggerForce) { this.staggerForce = staggerForce; }

    public Short getPushForce() { return pushForce; }
    public void setPushForce(Short pushForce) { this.pushForce = pushForce; }
}
