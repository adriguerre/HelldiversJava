package com.example.helldivers.domain;

import com.example.helldivers.enums.ObjectiveType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class Objective {

    @Id
    private Integer objective_id;
    private String name;
    private ObjectiveType objective_type;
    private String description;
    private Boolean is_primary;
    private Integer mission_id;
    private Boolean completed;
    private Timestamp completed_at;

    public Objective() {
    }

    public Objective(Integer objective_id, String name, ObjectiveType objective_type, String description,
                     Boolean is_primary, Integer mission_id, Boolean completed, Timestamp completed_at) {
        this.objective_id = objective_id;
        this.name = name;
        this.objective_type = objective_type;
        this.description = description;
        this.is_primary = is_primary;
        this.mission_id = mission_id;
        this.completed = completed;
        this.completed_at = completed_at;
    }

    public Integer getObjective_id() {
        return objective_id;
    }

    public void setObjective_id(Integer objective_id) {
        this.objective_id = objective_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectiveType getObjective_type() {
        return objective_type;
    }

    public void setObjective_type(ObjectiveType objective_type) {
        this.objective_type = objective_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIs_primary() {
        return is_primary;
    }

    public void setIs_primary(Boolean is_primary) {
        this.is_primary = is_primary;
    }

    public Integer getMission_id() {
        return mission_id;
    }

    public void setMission_id(Integer mission_id) {
        this.mission_id = mission_id;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Timestamp getCompleted_at() {
        return completed_at;
    }

    public void setCompleted_at(Timestamp completed_at) {
        this.completed_at = completed_at;
    }
}
