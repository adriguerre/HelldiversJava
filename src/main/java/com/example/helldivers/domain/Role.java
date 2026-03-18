package com.example.helldivers.domain;

import jakarta.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;
    private String name;

    public Role() {}

    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer role_id) { this.roleId = role_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
