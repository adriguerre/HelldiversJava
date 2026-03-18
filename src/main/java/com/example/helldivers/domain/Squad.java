package com.example.helldivers.domain;

import com.example.helldivers.enums.LobbyType;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "squad_id")
    private Integer squadId;
    @Column(name = "session_id")
    private String sessionId;
    @Column(name = "lobby_code")
    private String lobbyCode;
    @Column(name = "max_players")
    private Integer maxPlayers;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Enumerated(EnumType.STRING)
    @Column(name = "lobby_type")
    private LobbyType lobbyType;

    public Squad() {
    }

    public Squad(Integer squadId, String sessionId, String lobbyCode, Integer maxPlayers,
                 Timestamp createdAt, LobbyType lobbyType) {
        this.squadId = squadId;
        this.sessionId = sessionId;
        this.lobbyCode = lobbyCode;
        this.maxPlayers = maxPlayers;
        this.createdAt = createdAt;
        this.lobbyType = lobbyType;
    }

    public Integer getSquadId() {
        return squadId;
    }

    public void setSquadId(Integer squad_id) {
        this.squadId = squad_id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String session_id) {
        this.sessionId = session_id;
    }

    public String getLobbyCode() {
        return lobbyCode;
    }

    public void setLobbyCode(String lobby_code) {
        this.lobbyCode = lobby_code;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer max_players) {
        this.maxPlayers = max_players;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.createdAt = created_at;
    }

    public LobbyType getLobbyType() {
        return lobbyType;
    }

    public void setLobbyType(LobbyType lobby_type) {
        this.lobbyType = lobby_type;
    }
}
