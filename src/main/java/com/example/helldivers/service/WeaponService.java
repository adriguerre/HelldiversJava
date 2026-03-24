package com.example.helldivers.service;

import com.example.helldivers.domain.Ammo;
import com.example.helldivers.domain.Attachment;
import com.example.helldivers.domain.Weapon;
import com.example.helldivers.domain.WeaponAttachment;
import com.example.helldivers.enums.WeaponType;
import com.example.helldivers.repository.AmmoRepository;
import com.example.helldivers.repository.WeaponRepository;
import com.example.helldivers.specification.WeaponSpecification;
import com.example.helldivers.utils.UpdateUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@Lazy
public class WeaponService {

    private final WeaponRepository weaponRepository;
    private final AmmoRepository ammoRepository;

    public WeaponService(WeaponRepository weaponRepository, AmmoRepository ammoRepository){
        this.weaponRepository = weaponRepository;
        this.ammoRepository = ammoRepository;
    }

    public List<Weapon> getAllWeapons(WeaponType weaponType){
        return weaponRepository.findAll(WeaponSpecification.withFilters(weaponType));
    }

    public Optional<Weapon> getWeaponById(Integer weaponId){
        return weaponRepository.findById(weaponId);
    }

    public Optional<Weapon> addAmmoToWeapon(Integer weaponId, Integer ammoId) {
        Optional<Weapon> weaponOpt = weaponRepository.findById(weaponId);
        Optional<Ammo> ammoOpt = ammoRepository.findById(ammoId);

        if (weaponOpt.isEmpty() || ammoOpt.isEmpty()) return Optional.empty();

        Weapon weapon = weaponOpt.get();
        Ammo ammo = ammoOpt.get();

        if (!weapon.getAmmoTypes().contains(ammo)) {
            weapon.getAmmoTypes().add(ammo);
            weaponRepository.save(weapon);
        }

        return Optional.of(weapon);
    }

    public Optional<Weapon> removeAmmoFromWeapon(Integer weaponId, Integer ammoId) {
        Optional<Weapon> weaponOpt = weaponRepository.findById(weaponId);
        Optional<Ammo> ammoOpt = ammoRepository.findById(ammoId);

        if (weaponOpt.isEmpty() || ammoOpt.isEmpty()) return Optional.empty();

        Weapon weapon = weaponOpt.get();
        weapon.getAmmoTypes().remove(ammoOpt.get());
        weaponRepository.save(weapon);

        return Optional.of(weapon);
    }

    public Weapon createWeapon(Weapon weapon) {
        try {
            return weaponRepository.save(weapon);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error creating weapon");
        }
    }

    @Transactional
    public Weapon updateWeapon(Integer weaponId, Weapon weapon) {
        Weapon db = weaponRepository.findById(weaponId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Weapon with ID [" + weaponId + "] not found"));

        UpdateUtils.updateIfPresent(weapon::getName,              db::setName);
        UpdateUtils.updateIfPresent(weapon::getWeaponType,        db::setWeaponType);
        UpdateUtils.updateIfPresent(weapon::getMagSize,           db::setMagSize);
        UpdateUtils.updateIfPresent(weapon::getMaxAmmo,           db::setMaxAmmo);
        UpdateUtils.updateIfPresent(weapon::getRecoil,            db::setRecoil);
        UpdateUtils.updateIfPresent(weapon::getHorizontalRecoil,  db::setHorizontalRecoil);
        UpdateUtils.updateIfPresent(weapon::getVerticalRecoil,    db::setVerticalRecoil);
        UpdateUtils.updateIfPresent(weapon::getSpreadHorizontal,  db::setSpreadHorizontal);
        UpdateUtils.updateIfPresent(weapon::getSpreadVertical,    db::setSpreadVertical);
        UpdateUtils.updateIfPresent(weapon::getSway,              db::setSway);
        UpdateUtils.updateIfPresent(weapon::getFireRate,          db::setFireRate);
        UpdateUtils.updateIfPresent(weapon::getErgonomics,        db::setErgonomics);
        UpdateUtils.updateIfPresent(weapon::getSpareMagazines,    db::setSpareMagazines);
        UpdateUtils.updateIfPresent(weapon::getStartingMagazines, db::setStartingMagazines);
        UpdateUtils.updateIfPresent(weapon::getMagsFromSupply,    db::setMagsFromSupply);
        UpdateUtils.updateIfPresent(weapon::getMagsFromAmmoBox,   db::setMagsFromAmmoBox);
        UpdateUtils.updateIfPresent(weapon::getUnlockLevel,       db::setUnlockLevel);
        UpdateUtils.updateIfPresent(weapon::getReqCost,           db::setReqCost);
        UpdateUtils.updateIfPresent(weapon::getSuperCreditsCost,  db::setSuperCreditsCost);
        UpdateUtils.updateIfPresent(weapon::getImageUrl,          db::setImageUrl);

        return weaponRepository.save(db);
    }

    @Transactional
    public boolean deleteWeapon(Integer weaponId) {
        if (!weaponRepository.existsById(weaponId)) return false;
        weaponRepository.deleteById(weaponId);
        return true;
    }

    public List<Ammo> getAmmoByWeapon(Integer weaponId) {
        return weaponRepository.findById(weaponId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Weapon with ID [" + weaponId + "] not found"))
                .getAmmoTypes();
    }

    public List<WeaponAttachment> getAttachmentsByWeapon(Integer weaponId) {
        return weaponRepository.findById(weaponId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Weapon with ID [" + weaponId + "] not found"))
                .getAttachments();
    }

    public List<Weapon> getWeaponsByAmmo(Integer ammoId) {
        return weaponRepository.findByAmmoId(ammoId);
    }

    public List<Weapon> getWeaponsByAttachment(Integer attachmentId) {
        return weaponRepository.findByAttachmentId(attachmentId);
    }

    public Map<String, Object> getWeaponStats(Integer weaponId) {
        Weapon w = weaponRepository.findById(weaponId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Weapon with ID [" + weaponId + "] not found"));

        Map<String, Object> stats = new java.util.LinkedHashMap<>();
        stats.put("weapon_id",          w.getWeaponId());
        stats.put("name",               w.getName());
        stats.put("fire_rate",          w.getFireRate());
        stats.put("recoil",             w.getRecoil());
        stats.put("horizontal_recoil",  w.getHorizontalRecoil());
        stats.put("vertical_recoil",    w.getVerticalRecoil());
        stats.put("spread_horizontal",  w.getSpreadHorizontal());
        stats.put("spread_vertical",    w.getSpreadVertical());
        stats.put("sway",               w.getSway());
        stats.put("ergonomics",         w.getErgonomics());
        stats.put("mag_size",           w.getMagSize());
        stats.put("max_ammo",           w.getMaxAmmo());
        stats.put("spare_magazines",    w.getSpareMagazines());
        return stats;
    }
}
