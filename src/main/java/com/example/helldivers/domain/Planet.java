package com.example.helldivers.domain;


import com.example.helldivers.enums.BiomeType;
import com.example.helldivers.enums.FactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

@Entity
@BatchSize(size = 25)
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planet_id")
    private Integer planetId;
    @Column(name = "name")
    private String name;
    private String sector;
    @Column(name = "liberation_rate")
    private Double liberationRate;
    @Column(name = "coordinates_x")
    private Double coordinatesX;
    @Column(name = "coordinates_y")
    private Double coordinatesY;
    @Column(name = "max_health")
    private Double maxHealth;
    @Column(name = "current_health")
    private Double currentHealth;
    @Column(name = "regen_per_hour")
    private Double regenPerHour;
    @Enumerated(EnumType.STRING)
    private BiomeType biome;
    @Enumerated(EnumType.STRING)
    @Column(name = "owner_faction")
    private FactionType ownerFaction;
    @Column(name = "hazard_types")
    private String hazardTypes;

    public Planet() {
    }

    public Planet(Integer planetId, String name, String sector, Double liberationRate,
                  Double coordinatesX, Double coordinatesY, Double maxHealth, Double currentHealth,
                  Double regenPerHour, BiomeType biome, FactionType ownerFaction, String hazardTypes) {

        this.planetId = planetId;
        this.name = name;
        this.sector = sector;
        this.liberationRate = liberationRate;
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.regenPerHour = regenPerHour;
        this.biome = biome;
        this.ownerFaction = ownerFaction;
        this.hazardTypes = hazardTypes;
    }

    public Integer getPlanetId() {
        return planetId;
    }

    public void setPlanetId(Integer planet_id) {
        this.planetId = planet_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Double getLiberationRate() {
        return liberationRate;
    }

    public void setLiberationRate(Double liberation_rate) {
        this.liberationRate = liberation_rate;
    }

    public Double getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(Double coordinates_x) {
        this.coordinatesX = coordinates_x;
    }

    public Double getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(Double coordinates_y) {
        this.coordinatesY = coordinates_y;
    }

    public Double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(Double max_health) {
        this.maxHealth = max_health;
    }

    public Double getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(Double current_health) {
        this.currentHealth = current_health;
    }

    public Double getRegenPerHour() {
        return regenPerHour;
    }

    public void setRegenPerHour(Double regen_per_hour) {
        this.regenPerHour = regen_per_hour;
    }

    public BiomeType getBiome() {
        return biome;
    }

    public void setBiome(BiomeType biome) {
        this.biome = biome;
    }

    public FactionType getOwnerFaction() {
        return ownerFaction;
    }

    public void setOwnerFaction(FactionType owner_faction) {
        this.ownerFaction = owner_faction;
    }

    public String getHazardTypes() {
        return hazardTypes;
    }

    public void setHazardTypes(String hazard_types) {
        this.hazardTypes = hazard_types;
    }
}
