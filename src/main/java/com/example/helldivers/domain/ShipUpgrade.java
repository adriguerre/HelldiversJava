package com.example.helldivers.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Table(name = "ship_upgrade")
public class ShipUpgrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "upgrade_id")
    private Integer upgradeId;

    @Column(name = "module_name")
    private String moduleName;

    private Short tier;
    private String description;

    @Column(name = "effect_json")
    private String effectJson;

    @Column(name = "common_samples")
    private Integer commonSamples;

    @Column(name = "rare_samples")
    private Integer rareSamples;

    @Column(name = "super_samples")
    private Integer superSamples;

    @ManyToOne
    @JoinColumn(name = "parent_upgrade_id")
    private ShipUpgrade parentUpgrade;

    @OneToMany(mappedBy = "parentUpgrade")
    @BatchSize(size = 25)
    private List<ShipUpgrade> childUpgrades;

    @ManyToMany(mappedBy = "shipModules")
    @BatchSize(size = 25)
    private List<Stratagem> stratagems;

    public ShipUpgrade() {}

    public Integer getUpgradeId() {
        return upgradeId;
    }

    public void setUpgradeId(Integer upgradeId) {
        this.upgradeId = upgradeId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Short getTier() {
        return tier;
    }

    public void setTier(Short tier) {
        this.tier = tier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEffectJson() {
        return effectJson;
    }

    public void setEffectJson(String effectJson) {
        this.effectJson = effectJson;
    }

    public Integer getCommonSamples() {
        return commonSamples;
    }

    public void setCommonSamples(Integer commonSamples) {
        this.commonSamples = commonSamples;
    }

    public Integer getRareSamples() {
        return rareSamples;
    }

    public void setRareSamples(Integer rareSamples) {
        this.rareSamples = rareSamples;
    }

    public Integer getSuperSamples() {
        return superSamples;
    }

    public void setSuperSamples(Integer superSamples) {
        this.superSamples = superSamples;
    }

    public ShipUpgrade getParentUpgrade() {
        return parentUpgrade;
    }

    public void setParentUpgrade(ShipUpgrade parentUpgrade) {
        this.parentUpgrade = parentUpgrade;
    }

    public List<ShipUpgrade> getChildUpgrades() {
        return childUpgrades;
    }

    public void setChildUpgrades(List<ShipUpgrade> childUpgrades) {
        this.childUpgrades = childUpgrades;
    }

    public List<Stratagem> getStratagems() {
        return stratagems;
    }

    public void setStratagems(List<Stratagem> stratagems) {
        this.stratagems = stratagems;
    }
}