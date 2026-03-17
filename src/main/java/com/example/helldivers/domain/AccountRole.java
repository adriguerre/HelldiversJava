package com.example.helldivers.domain;

import jakarta.persistence.*;

@Entity
@Table(name="account_role")
public class AccountRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "role_id")
    private Integer roleId;

    public AccountRole() {}

    public AccountRole(Long accountId, Integer roleId) {
        this.accountId = accountId;
        this.roleId = roleId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }


    public Long getAccountId() { return accountId; }
    public void setAccountId(Long accountId) { this.accountId = accountId; }
    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer roleId) { this.roleId = roleId; }
}