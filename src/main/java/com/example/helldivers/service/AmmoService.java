package com.example.helldivers.service;

import com.example.helldivers.domain.Ammo;
import com.example.helldivers.domain.Planet;
import com.example.helldivers.repository.AmmoRepository;
import com.example.helldivers.specification.AmmoSpecification;
import com.example.helldivers.utils.UpdateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AmmoService {

    private AmmoRepository ammoRepository;

    @Autowired
    public AmmoService(AmmoRepository ammoRepository){
        this.ammoRepository = ammoRepository;
    }

    @Transactional(readOnly = true)
    public List<Ammo> getAmmoWithParams(String caliber, String pen){
        return ammoRepository.findAll(AmmoSpecification.withFilters(caliber, pen));
    }

    @Transactional(readOnly = true)
    public Optional<Ammo> getAmmoById(Integer ammoId){
        return ammoRepository.findById(ammoId);
    }

    public Ammo createAmmo(Ammo newAmmo){
        try{
            Ammo ammo = ammoRepository.save(newAmmo);
            return ammo;
        }catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ammo received a problem, try again later");
        }
    }

    @Transactional
    public Boolean deleteAmmoById(Integer ammoId){
        if (ammoRepository.existsById(ammoId)) {
            ammoRepository.deleteById(ammoId);
            return true;
        }
        return false;
    }

    @Transactional
    public Object updateAmmo(Integer ammoId, Ammo ammo) {
        Ammo db = ammoRepository.findById(ammoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Planet with ID [" + ammoId + "] not found"));

        UpdateUtils.updateIfPresent(ammo::getName,                      db::setName);
        UpdateUtils.updateIfPresent(ammo::getCaliber,                   db::setCaliber);
        UpdateUtils.updateIfPresent(ammo::getDamageDurable,             db::setDamageDurable);
        UpdateUtils.updateIfPresent(ammo::getDamageDurableType,         db::setDamageDurableType);
        UpdateUtils.updateIfPresent(ammo::getDamageStandard,            db::setDamageStandard);
        UpdateUtils.updateIfPresent(ammo::getDamageStandardType,        db::setDamageStandardType);
        UpdateUtils.updateIfPresent(ammo::getDemolitionForce,           db::setDemolitionForce);
        UpdateUtils.updateIfPresent(ammo::getDragFactorPct,             db::setDragFactorPct);
        UpdateUtils.updateIfPresent(ammo::getGravityFactorPct,          db::setGravityFactorPct);
        UpdateUtils.updateIfPresent(ammo::getInitialVelocityMs,         db::setInitialVelocityMs);
        UpdateUtils.updateIfPresent(ammo::getMassGrams,                 db::setMassGrams);
        UpdateUtils.updateIfPresent(ammo::getPenetrationDirect,         db::setPenetrationDirect);
        UpdateUtils.updateIfPresent(ammo::getPenetrationDirectName,     db::setPenetrationDirectName);
        UpdateUtils.updateIfPresent(ammo::getPenetrationExtremeAngle,   db::setPenetrationExtremeAngle);
        UpdateUtils.updateIfPresent(ammo::getPenetrationExtremeName,    db::setPenetrationExtremeName);
        UpdateUtils.updateIfPresent(ammo::getPenetrationLargeAngle,     db::setPenetrationLargeAngle);
        UpdateUtils.updateIfPresent(ammo::getPenetrationLargeName,      db::setPenetrationLargeName);
        UpdateUtils.updateIfPresent(ammo::getPenetrationSlightAngle,    db::setPenetrationSlightAngle);
        UpdateUtils.updateIfPresent(ammo::getPenetrationSlightName,     db::setPenetrationSlightName);
        UpdateUtils.updateIfPresent(ammo::getPenetrationSlowdownPct,    db::setPenetrationSlowdownPct);
        UpdateUtils.updateIfPresent(ammo::getPushForce,                 db::setPushForce);
        UpdateUtils.updateIfPresent(ammo::getStaggerForce,              db::setStaggerForce);

        return ammoRepository.save(db);
    }
}
