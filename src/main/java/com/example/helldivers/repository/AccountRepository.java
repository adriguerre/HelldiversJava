package com.example.helldivers.repository;

import com.example.helldivers.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {

    List<Account> findByRegion(String region);
    Optional<Account> findByEmail(String email);
    @Query("SELECT a.account_id FROM Account a")
    List<Integer> findAllAccountIds();
}
