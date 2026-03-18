package com.example.helldivers.domain;

import com.example.helldivers.enums.ObjectiveType;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Objective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "objective_id")
    private Integer objectiveId;
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "objective_type")
    private ObjectiveType objectiveType;
    private String description;
    @Column(name = "is_primary")
    private Boolean isPrimary;
    @Column(name = "mission_id")
    private Integer missionId;
    private Boolean completed;
    @Column(name = "completed_at")
    private Timestamp completedAt;

    public Objective() {
    }

    public Objective(Integer objectiveId, String name, ObjectiveType objectiveType, String description,
                     Boolean isPrimary, Integer missionId, Boolean completed, Timestamp completedAt) {
        this.objectiveId = objectiveId;
        this.name = name;
        this.objectiveType = objectiveType;
        this.description = description;
        this.isPrimary = isPrimary;
        this.missionId = missionId;
        this.completed = completed;
        this.completedAt = completedAt;
    }

    public Integer getObjectiveId() {
        return objectiveId;
    }

    public void setObjectiveId(Integer objective_id) {
        this.objectiveId = objective_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectiveType getObjectiveType() {
        return objectiveType;
    }

    public void setObjectiveType(ObjectiveType objective_type) {
        this.objectiveType = objective_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean is_primary) {
        this.isPrimary = is_primary;
    }

    public Integer getMissionId() {
        return missionId;
    }

    public void setMissionId(Integer mission_id) {
        this.missionId = mission_id;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Timestamp getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Timestamp completed_at) {
        this.completedAt = completed_at;
    }
}
