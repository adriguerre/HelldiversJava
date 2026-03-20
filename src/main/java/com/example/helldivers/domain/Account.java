package com.example.helldivers.domain;


import com.example.helldivers.enums.PlatformType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer account_id;
    @Column(name = "platform_id")
    private String platformId;
    @Enumerated(EnumType.STRING)
    @JsonProperty("platform_type")
    @Column(name = "platform_type")
    private PlatformType platformType;
    private String psn_steam_id;
    @NotBlank(message = "Email is required")
    private String email;
    private String region;
    @Column(name = "is_banned")
    private Boolean isBanned;
    @Column(name = "ban_reason")
    private String banReason;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "last_login")
    private Timestamp lastLogin;
    @JsonProperty("password")
    @Column(name = "password")
    private String password;

    public Account() {
    }

    public Account(Integer account_id, String platformId, PlatformType platformType,
                   String email, String region, Boolean isBanned, Timestamp createdAt,
                   Timestamp lastLogin, String password) {
        this.account_id = account_id;
        this.platformId = platformId;
        this.platformType = platformType;
        this.email = email;
        this.region = region;
        this.isBanned = isBanned;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.password = password;
    }


    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platform_id) {
        this.platformId = platform_id;
    }

    public PlatformType getPlatformType() {
        return platformType;
    }

    public void setPlatformType(PlatformType platformType) {
        this.platformType = platformType;
    }

    public String getPsn_steam_id() {
        return psn_steam_id;
    }

    public void setPsn_steam_id(String psn_steam_id) {
        this.psn_steam_id = psn_steam_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Boolean isIsBanned() {
        return isBanned;
    }

    public void setIsBanned(Boolean is_banned) {
        this.isBanned = is_banned;
    }

    public String getBanReason() {
        return banReason;
    }

    public void setBanReason(String ban_reason) {
        this.banReason = ban_reason;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.createdAt = created_at;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp last_login) {
        this.lastLogin = last_login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
