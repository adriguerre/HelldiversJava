package com.example.helldivers.service;

import com.example.helldivers.domain.Attachment;
import com.example.helldivers.domain.Weapon;
import com.example.helldivers.domain.WeaponAttachment;
import com.example.helldivers.domain.WeaponAttachmentId;
import com.example.helldivers.repository.AttachmentRepository;
import com.example.helldivers.repository.WeaponAttachmentRepository;
import com.example.helldivers.repository.WeaponRepository;
import com.example.helldivers.specification.AttachmentSpecification;
import com.example.helldivers.utils.UpdateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final WeaponAttachmentRepository weaponAttachmentRepository;
    private final WeaponRepository weaponRepository;

    public AttachmentService(AttachmentRepository attachmentRepository,
                             WeaponAttachmentRepository weaponAttachmentRepository,
                             WeaponRepository weaponRepository) {
        this.attachmentRepository = attachmentRepository;
        this.weaponAttachmentRepository = weaponAttachmentRepository;
        this.weaponRepository = weaponRepository;
    }

    public List<Attachment> getAllAttachments(String category) {
        return attachmentRepository.findAll(AttachmentSpecification.withFilters(category));
    }

    public Optional<Attachment> getAttachmentById(Integer id) {
        return attachmentRepository.findById(id);
    }

    public Attachment createAttachment(Attachment attachment) {
        try {
            return attachmentRepository.save(attachment);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error creating attachment");
        }
    }

    @Transactional
    public Attachment updateAttachment(Integer id, Attachment attachment) {
        Attachment db = attachmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Attachment with ID [" + id + "] not found"));

        UpdateUtils.updateIfPresent(attachment::getName, db::setName);
        UpdateUtils.updateIfPresent(attachment::getCategory, db::setCategory);

        return attachmentRepository.save(db);
    }

    @Transactional
    public boolean deleteAttachment(Integer id) {
        if (!attachmentRepository.existsById(id)) return false;
        attachmentRepository.deleteById(id);
        return true;
    }

    public WeaponAttachment linkAttachmentToWeapon(Integer weaponId, Integer attachmentId,
                                                    Integer weaponUnlockLevel, Integer unlockCost, String effect) {
        Weapon weapon = weaponRepository.findById(weaponId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Weapon with ID [" + weaponId + "] not found"));

        Attachment attachment = attachmentRepository.findById(attachmentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Attachment with ID [" + attachmentId + "] not found"));

        WeaponAttachmentId waId = new WeaponAttachmentId(weaponId, attachmentId);

        if (weaponAttachmentRepository.existsById(waId))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This attachment is already linked to the weapon");

        WeaponAttachment wa = new WeaponAttachment();
        wa.setId(waId);
        wa.setWeapon(weapon);
        wa.setAttachment(attachment);
        wa.setWeaponUnlockLevel(weaponUnlockLevel);
        wa.setUnlockCost(unlockCost);
        wa.setEffect(effect);

        return weaponAttachmentRepository.save(wa);
    }

    @Transactional
    public void unlinkAttachmentFromWeapon(Integer weaponId, Integer attachmentId) {
        WeaponAttachmentId waId = new WeaponAttachmentId(weaponId, attachmentId);
        if (!weaponAttachmentRepository.existsById(waId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Link between weapon and attachment not found");
        weaponAttachmentRepository.deleteById(waId);
    }
}
