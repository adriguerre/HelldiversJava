package com.example.helldivers.domain;


import com.example.helldivers.enums.PlatformType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer account_id;
    private String platform_id;
    @Enumerated(EnumType.STRING)
    @JsonProperty("platform_type")
    private PlatformType platform_type;
    private String psn_steam_id;
    @NotBlank(message = "Email is required")
    private String email;
    private String region;
    private boolean is_banned;
    private String ban_reason;
    private Timestamp created_at;
    private Timestamp last_login;
    @JsonProperty("password")
    private String encryptedPassword;

    public Account() {
    }

    public Account(Integer account_id, String platform_id, PlatformType platformType,
                   String email, String region, boolean is_banned, Timestamp created_at,
                   Timestamp last_login, String encryptedPassword) {
        this.account_id = account_id;
        this.platform_id = platform_id;
        this.platform_type = platformType;
        this.email = email;
        this.region = region;
        this.is_banned = is_banned;
        this.created_at = created_at;
        this.last_login = last_login;
        this.encryptedPassword = encryptedPassword;
    }


    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public String getPlatform_id() {
        return platform_id;
    }

    public void setPlatform_id(String platform_id) {
        this.platform_id = platform_id;
    }

    public PlatformType getPlatform_type() {
        return platform_type;
    }

    public void setPlatform_type(PlatformType platformType) {
        this.platform_type = platformType;
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

    public boolean isIs_banned() {
        return is_banned;
    }

    public void setIs_banned(boolean is_banned) {
        this.is_banned = is_banned;
    }

    public String getBan_reason() {
        return ban_reason;
    }

    public void setBan_reason(String ban_reason) {
        this.ban_reason = ban_reason;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getLast_login() {
        return last_login;
    }

    public void setLast_login(Timestamp last_login) {
        this.last_login = last_login;
    }

    public String getPassword() {
        return encryptedPassword;
    }

    public void setPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
}
