package com.example.helldivers.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;

@Entity
@Table(name = "weapon_attachment")
public class WeaponAttachment {

    @EmbeddedId
    @JsonIgnore
    private WeaponAttachmentId id;

    @ManyToOne
    @MapsId("weaponId")
    @JoinColumn(name = "weapon_id")
    @JsonIgnore
    private Weapon weapon;

    @ManyToOne
    @MapsId("attachmentId")
    @JoinColumn(name = "attachment_id")
    @JsonUnwrapped
    private Attachment attachment;

    @Column(name = "weapon_unlock_level")
    @JsonProperty("weapon_unlock_level")
    private Integer weaponUnlockLevel;

    @Column(name = "unlock_cost")
    @JsonProperty("unlock_cost")
    private Integer unlockCost;

    private String effect;

    public WeaponAttachment() {}

    public WeaponAttachmentId getId() { return id; }
    public void setId(WeaponAttachmentId id) { this.id = id; }

    public Weapon getWeapon() { return weapon; }
    public void setWeapon(Weapon weapon) { this.weapon = weapon; }

    public Attachment getAttachment() { return attachment; }
    public void setAttachment(Attachment attachment) { this.attachment = attachment; }

    public Integer getWeaponUnlockLevel() { return weaponUnlockLevel; }
    public void setWeaponUnlockLevel(Integer weaponUnlockLevel) { this.weaponUnlockLevel = weaponUnlockLevel; }

    public Integer getUnlockCost() { return unlockCost; }
    public void setUnlockCost(Integer unlockCost) { this.unlockCost = unlockCost; }

    public String getEffect() { return effect; }
    public void setEffect(String effect) { this.effect = effect; }
}
