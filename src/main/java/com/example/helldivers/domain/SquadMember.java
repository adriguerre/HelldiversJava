package com.example.helldivers.domain;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class SquadMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "squad_member")
    private Integer squadMember;
    @Column(name = "squad_id")
    private Integer squadId;
    @Column(name = "helldivers_id")
    private Integer helldiversId;
    @Column(name = "is_host")
    private boolean isHost;
    @Column(name = "joined_at")
    private Timestamp joinedAt;
    @Column(name = "slot_number")
    private Integer slotNumber;

    public SquadMember() {
    }

    public SquadMember(Integer squadMember, Integer squadId, Integer helldiversId,
                       boolean isHost, Timestamp joinedAt, Integer slotNumber) {
        this.squadMember = squadMember;
        this.squadId = squadId;
        this.helldiversId = helldiversId;
        this.isHost = isHost;
        this.joinedAt = joinedAt;
        this.slotNumber = slotNumber;
    }

    public Integer getSquadMember() {
        return squadMember;
    }

    public void setSquadMember(Integer squad_member) {
        this.squadMember = squad_member;
    }

    public Integer getSquadId() {
        return squadId;
    }

    public void setSquadId(Integer squad_id) {
        this.squadId = squad_id;
    }

    public Integer getHelldiversId() {
        return helldiversId;
    }

    public void setHelldiversId(Integer helldivers_id) {
        this.helldiversId = helldivers_id;
    }

    public boolean isIsHost() {
        return isHost;
    }

    public void setIsHost(boolean is_host) {
        this.isHost = is_host;
    }

    public Timestamp getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(Timestamp joined_at) {
        this.joinedAt = joined_at;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Integer slot_number) {
        this.slotNumber = slot_number;
    }
}
