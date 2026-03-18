package com.example.helldivers.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "stratagem_attack_status")
public class StratagemAttackStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Integer statusId;

    @ManyToOne
    @JoinColumn(name = "attack_id")
    private StratagemAttack attack;

    @Column(name = "sort_order")
    private Short sortOrder;

    @Column(name = "status_name")
    private String statusName;

    @Column(name = "status_strength")
    private Double statusStrength;

    @Column(name = "status_duration_sec")
    private Double statusDurationSec;

    public StratagemAttackStatus() {}

    public Integer getStatusId() { return statusId; }
    public void setStatusId(Integer statusId) { this.statusId = statusId; }

    @JsonIgnore
    public StratagemAttack getAttack() { return attack; }
    public void setAttack(StratagemAttack attack) { this.attack = attack; }

    public Short getSortOrder() { return sortOrder; }
    public void setSortOrder(Short sortOrder) { this.sortOrder = sortOrder; }

    public String getStatusName() { return statusName; }
    public void setStatusName(String statusName) { this.statusName = statusName; }

    public Double getStatusStrength() { return statusStrength; }
    public void setStatusStrength(Double statusStrength) { this.statusStrength = statusStrength; }

    public Double getStatusDurationSec() { return statusDurationSec; }
    public void setStatusDurationSec(Double statusDurationSec) { this.statusDurationSec = statusDurationSec; }
}