package com.example.helldivers.service;

import com.example.helldivers.domain.Stratagem;
import com.example.helldivers.domain.StratagemAttack;
import com.example.helldivers.repository.StratagemAttackRepository;
import com.example.helldivers.repository.StratagemRepository;
import com.example.helldivers.utils.UpdateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StratagemAttackService {

    private final StratagemAttackRepository attackRepository;
    private final StratagemRepository stratagemRepository;

    public StratagemAttackService(StratagemAttackRepository attackRepository,
                                   StratagemRepository stratagemRepository) {
        this.attackRepository = attackRepository;
        this.stratagemRepository = stratagemRepository;
    }

    public List<StratagemAttack> getAttacksByStratagem(Integer stratagemId) {
        if (!stratagemRepository.existsById(stratagemId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Stratagem with ID [" + stratagemId + "] not found");
        return attackRepository.findByStratagem_StratagemId(stratagemId);
    }

    public Optional<StratagemAttack> getAttackById(Integer attackId) {
        return attackRepository.findById(attackId);
    }

    public StratagemAttack createAttack(Integer stratagemId, StratagemAttack attack) {
        Stratagem stratagem = stratagemRepository.findById(stratagemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Stratagem with ID [" + stratagemId + "] not found"));
        attack.setStratagem(stratagem);
        try {
            return attackRepository.save(attack);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error creating stratagem attack");
        }
    }

    @Transactional
    public StratagemAttack updateAttack(Integer attackId, StratagemAttack attack) {
        StratagemAttack db = attackRepository.findById(attackId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Attack with ID [" + attackId + "] not found"));

        UpdateUtils.updateIfPresent(attack::getAttackName,            db::setAttackName);
        UpdateUtils.updateIfPresent(attack::getAttackType,            db::setAttackType);
        UpdateUtils.updateIfPresent(attack::getSortOrder,             db::setSortOrder);
        UpdateUtils.updateIfPresent(attack::getDamageElement,         db::setDamageElement);
        UpdateUtils.updateIfPresent(attack::getDamageStandard,        db::setDamageStandard);
        UpdateUtils.updateIfPresent(attack::getDamageStandardType,    db::setDamageStandardType);
        UpdateUtils.updateIfPresent(attack::getDamageVsDurable,       db::setDamageVsDurable);
        UpdateUtils.updateIfPresent(attack::getDamageVsDurableType,   db::setDamageVsDurableType);
        UpdateUtils.updateIfPresent(attack::getInnerRadiusM,          db::setInnerRadiusM);
        UpdateUtils.updateIfPresent(attack::getOuterRadiusM,          db::setOuterRadiusM);
        UpdateUtils.updateIfPresent(attack::getShockwaveRadiusM,      db::setShockwaveRadiusM);
        UpdateUtils.updateIfPresent(attack::getInnerDamage,           db::setInnerDamage);
        UpdateUtils.updateIfPresent(attack::getInnerDamageType,       db::setInnerDamageType);
        UpdateUtils.updateIfPresent(attack::getInnerDurable,          db::setInnerDurable);
        UpdateUtils.updateIfPresent(attack::getInnerDurableType,      db::setInnerDurableType);
        UpdateUtils.updateIfPresent(attack::getOuterDamage,           db::setOuterDamage);
        UpdateUtils.updateIfPresent(attack::getOuterDurable,          db::setOuterDurable);
        UpdateUtils.updateIfPresent(attack::getAoePenetrationLevel,   db::setAoePenetrationLevel);
        UpdateUtils.updateIfPresent(attack::getAoePenetrationName,    db::setAoePenetrationName);
        UpdateUtils.updateIfPresent(attack::getPenetrationDirect,     db::setPenetrationDirect);
        UpdateUtils.updateIfPresent(attack::getPenetrationDirectName, db::setPenetrationDirectName);
        UpdateUtils.updateIfPresent(attack::getCaliber,               db::setCaliber);
        UpdateUtils.updateIfPresent(attack::getMassGrams,             db::setMassGrams);
        UpdateUtils.updateIfPresent(attack::getDemolitionForce,       db::setDemolitionForce);
        UpdateUtils.updateIfPresent(attack::getStaggerForce,          db::setStaggerForce);
        UpdateUtils.updateIfPresent(attack::getPushForce,             db::setPushForce);

        return attackRepository.save(db);
    }

    @Transactional
    public boolean deleteAttack(Integer attackId) {
        if (!attackRepository.existsById(attackId)) return false;
        attackRepository.deleteById(attackId);
        return true;
    }
}
