package com.example.helldivers.repository;

import com.example.helldivers.domain.Account;
import com.example.helldivers.domain.Helldiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HelldiverRepository extends JpaRepository<Helldiver, Integer>, JpaSpecificationExecutor<Helldiver> {

    void deleteByHelldiverId(Integer helldiverId);
    Optional<Helldiver> findByCallSign(String callSign);
    Optional<Helldiver> findByHelldiverId(Integer helldiverId);
    Optional<Helldiver> findByAccount(Account account);
    @Query("SELECT h FROM Helldiver h WHERE h.account.account_id = :accountId")
    Optional<Helldiver> findByAccountId(@Param("accountId") Integer accountId);
    List<Helldiver> findByAccountIsNull();
}
