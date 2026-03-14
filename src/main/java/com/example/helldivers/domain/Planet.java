package com.example.helldivers.domain;


import com.example.helldivers.enums.BiomeType;
import com.example.helldivers.enums.FactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Planet {

    @Id
    private Integer planet_id;
    private String name;
    private String sector;
    private Double liberation_rate;
    private Double coordinates_x;
    private Double coordinates_y;
    private Double max_health;
    private Double current_health;
    private Double regen_per_hour;
    private BiomeType biome;
    private FactionType owner_faction;
    private String hazard_types;

    public Planet() {
    }

    public Planet(Integer planet_id, String name, String sector, Double liberation_rate,
                  Double coordinates_x, Double coordinates_y, Double max_health, Double current_health,
                  Double regen_per_hour, BiomeType biome, FactionType owner_faction, String hazard_types) {

        this.planet_id = planet_id;
        this.name = name;
        this.sector = sector;
        this.liberation_rate = liberation_rate;
        this.coordinates_x = coordinates_x;
        this.coordinates_y = coordinates_y;
        this.max_health = max_health;
        this.current_health = current_health;
        this.regen_per_hour = regen_per_hour;
        this.biome = biome;
        this.owner_faction = owner_faction;
        this.hazard_types = hazard_types;
    }

    public Integer getPlanet_id() {
        return planet_id;
    }

    public void setPlanet_id(Integer planet_id) {
        this.planet_id = planet_id;
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

    public Double getLiberation_rate() {
        return liberation_rate;
    }

    public void setLiberation_rate(Double liberation_rate) {
        this.liberation_rate = liberation_rate;
    }

    public Double getCoordinates_x() {
        return coordinates_x;
    }

    public void setCoordinates_x(Double coordinates_x) {
        this.coordinates_x = coordinates_x;
    }

    public Double getCoordinates_y() {
        return coordinates_y;
    }

    public void setCoordinates_y(Double coordinates_y) {
        this.coordinates_y = coordinates_y;
    }

    public Double getMax_health() {
        return max_health;
    }

    public void setMax_health(Double max_health) {
        this.max_health = max_health;
    }

    public Double getCurrent_health() {
        return current_health;
    }

    public void setCurrent_health(Double current_health) {
        this.current_health = current_health;
    }

    public Double getRegen_per_hour() {
        return regen_per_hour;
    }

    public void setRegen_per_hour(Double regen_per_hour) {
        this.regen_per_hour = regen_per_hour;
    }

    public BiomeType getBiome() {
        return biome;
    }

    public void setBiome(BiomeType biome) {
        this.biome = biome;
    }

    public FactionType getOwner_faction() {
        return owner_faction;
    }

    public void setOwner_faction(FactionType owner_faction) {
        this.owner_faction = owner_faction;
    }

    public String getHazard_types() {
        return hazard_types;
    }

    public void setHazard_types(String hazard_types) {
        this.hazard_types = hazard_types;
    }
}
