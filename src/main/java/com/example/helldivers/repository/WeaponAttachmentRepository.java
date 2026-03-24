package com.example.helldivers.repository;

import com.example.helldivers.domain.WeaponAttachment;
import com.example.helldivers.domain.WeaponAttachmentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponAttachmentRepository extends JpaRepository<WeaponAttachment, WeaponAttachmentId> {
}
