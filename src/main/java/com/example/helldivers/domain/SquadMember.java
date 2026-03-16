package com.example.helldivers.domain;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class SquadMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer squad_member;
    private Integer squad_id;
    private Integer helldivers_id;
    private boolean is_host;
    private Timestamp joined_at;
    private Integer slot_number;

    public SquadMember() {
    }

    public SquadMember(Integer squad_member, Integer squad_id, Integer helldivers_id,
                       boolean is_host, Timestamp joined_at, Integer slot_number) {
        this.squad_member = squad_member;
        this.squad_id = squad_id;
        this.helldivers_id = helldivers_id;
        this.is_host = is_host;
        this.joined_at = joined_at;
        this.slot_number = slot_number;
    }

    public Integer getSquad_member() {
        return squad_member;
    }

    public void setSquad_member(Integer squad_member) {
        this.squad_member = squad_member;
    }

    public Integer getSquad_id() {
        return squad_id;
    }

    public void setSquad_id(Integer squad_id) {
        this.squad_id = squad_id;
    }

    public Integer getHelldivers_id() {
        return helldivers_id;
    }

    public void setHelldivers_id(Integer helldivers_id) {
        this.helldivers_id = helldivers_id;
    }

    public boolean isIs_host() {
        return is_host;
    }

    public void setIs_host(boolean is_host) {
        this.is_host = is_host;
    }

    public Timestamp getJoined_at() {
        return joined_at;
    }

    public void setJoined_at(Timestamp joined_at) {
        this.joined_at = joined_at;
    }

    public Integer getSlot_number() {
        return slot_number;
    }

    public void setSlot_number(Integer slot_number) {
        this.slot_number = slot_number;
    }
}
