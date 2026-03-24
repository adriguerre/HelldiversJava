package com.example.helldivers.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class WeaponAttachmentId implements Serializable {

    @Column(name = "weapon_id")
    private Integer weaponId;

    @Column(name = "attachment_id")
    private Integer attachmentId;

    public WeaponAttachmentId() {}

    public WeaponAttachmentId(Integer weaponId, Integer attachmentId) {
        this.weaponId = weaponId;
        this.attachmentId = attachmentId;
    }

    public Integer getWeaponId() { return weaponId; }
    public void setWeaponId(Integer weaponId) { this.weaponId = weaponId; }

    public Integer getAttachmentId() { return attachmentId; }
    public void setAttachmentId(Integer attachmentId) { this.attachmentId = attachmentId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeaponAttachmentId)) return false;
        WeaponAttachmentId that = (WeaponAttachmentId) o;
        return Objects.equals(weaponId, that.weaponId) && Objects.equals(attachmentId, that.attachmentId);
    }

    @Override
    public int hashCode() { return Objects.hash(weaponId, attachmentId); }
}
