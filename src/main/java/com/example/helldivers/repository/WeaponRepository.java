package com.example.helldivers.repository;

import com.example.helldivers.domain.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer>, JpaSpecificationExecutor<Weapon> {

    Optional<Weapon> findByName(String name);

    @Query("SELECT w FROM Weapon w JOIN w.ammoTypes a WHERE a.ammoId = :ammoId")
    List<Weapon> findByAmmoId(@Param("ammoId") Integer ammoId);

    @Query("SELECT w FROM Weapon w JOIN w.attachments wa WHERE wa.attachment.attachmentId = :attachmentId")
    List<Weapon> findByAttachmentId(@Param("attachmentId") Integer attachmentId);
}
