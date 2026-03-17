package com.example.helldivers.repository;

import com.example.helldivers.domain.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRoleRepository extends JpaRepository<AccountRole, Integer> {
    AccountRole findByAccountId(Long account_id);
}