package com.example.helldivers.repository;

import com.example.helldivers.domain.SquadMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SquadMemberRepository extends JpaRepository<SquadMember, Integer> {

    boolean existsBySquadIdAndHelldiversId(Integer squadId, Integer helldiversId);
    List<SquadMember> findBySquadId(Integer squadId);
}
