package com.example.helldivers.domain;

import com.example.helldivers.enums.LobbyType;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer squad_id;
    private String session_id;
    private String lobby_code;
    private Integer max_players;
    private Timestamp created_at;
    @Enumerated(EnumType.STRING)
    private LobbyType lobby_type;

    public Squad() {
    }

    public Squad(Integer squad_id, String session_id, String lobby_code, Integer max_players,
                 Timestamp created_at, LobbyType lobby_type) {
        this.squad_id = squad_id;
        this.session_id = session_id;
        this.lobby_code = lobby_code;
        this.max_players = max_players;
        this.created_at = created_at;
        this.lobby_type = lobby_type;
    }

    public Integer getSquad_id() {
        return squad_id;
    }

    public void setSquad_id(Integer squad_id) {
        this.squad_id = squad_id;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getLobby_code() {
        return lobby_code;
    }

    public void setLobby_code(String lobby_code) {
        this.lobby_code = lobby_code;
    }

    public Integer getMax_players() {
        return max_players;
    }

    public void setMax_players(Integer max_players) {
        this.max_players = max_players;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public LobbyType getLobby_type() {
        return lobby_type;
    }

    public void setLobby_type(LobbyType lobby_type) {
        this.lobby_type = lobby_type;
    }
}
