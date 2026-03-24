package com.example.helldivers.service;

import com.example.helldivers.domain.Stratagem;
import com.example.helldivers.domain.StratagemEntity;
import com.example.helldivers.repository.StratagemEntityRepository;
import com.example.helldivers.repository.StratagemRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.example.helldivers.utils.UpdateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class StratagemEntityService {

    private final StratagemEntityRepository entityRepository;
    private final StratagemRepository stratagemRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public StratagemEntityService(StratagemEntityRepository entityRepository,
                                   StratagemRepository stratagemRepository) {
        this.entityRepository = entityRepository;
        this.stratagemRepository = stratagemRepository;
    }

    public Optional<StratagemEntity> getEntityByStratagem(Integer stratagemId) {
        if (!stratagemRepository.existsById(stratagemId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Stratagem with ID [" + stratagemId + "] not found");
        return entityRepository.findByStratagem_StratagemId(stratagemId);
    }

    public StratagemEntity createEntity(Integer stratagemId, StratagemEntity entity) {
        Stratagem stratagem = stratagemRepository.findById(stratagemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Stratagem with ID [" + stratagemId + "] not found"));

        if (entityRepository.findByStratagem_StratagemId(stratagemId).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Stratagem with ID [" + stratagemId + "] already has an entity");

        entity.setStratagem(stratagem);
        try {
            return entityRepository.save(entity);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error creating stratagem entity");
        }
    }

    @Transactional
    public StratagemEntity updateEntity(Integer stratagemId, StratagemEntity entity) {
        StratagemEntity db = entityRepository.findByStratagem_StratagemId(stratagemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No entity found for stratagem with ID [" + stratagemId + "]"));

        UpdateUtils.updateIfPresent(entity::getEntityName,          db::setEntityName);
        UpdateUtils.updateIfPresent(entity::getMainHealth,          db::setMainHealth);
        UpdateUtils.updateIfPresent(entity::getMainArmor,           db::setMainArmor);
        UpdateUtils.updateIfPresent(entity::getMainArmorLevel,      db::setMainArmorLevel);
        UpdateUtils.updateIfPresent(entity::getHorizontalTurnSpeed, db::setHorizontalTurnSpeed);
        UpdateUtils.updateIfPresent(entity::getVerticalTurnSpeed,   db::setVerticalTurnSpeed);
        UpdateUtils.updateIfPresent(entity::getVerticalLimitMin,    db::setVerticalLimitMin);
        UpdateUtils.updateIfPresent(entity::getVerticalLimitMax,    db::setVerticalLimitMax);
        UpdateUtils.updateIfPresent(entity::getLifetimeSecs,        db::setLifetimeSecs);
        UpdateUtils.updateIfPresent(entity::getMagsFromSupply,      db::setMagsFromSupply);
        UpdateUtils.updateIfPresent(entity::getMagsFromAmmoBox,     db::setMagsFromAmmoBox);
        UpdateUtils.updateIfPresent(entity::getMaxRounds,           db::setMaxRounds);
        UpdateUtils.updateIfPresent(entity::getStartingRounds,      db::setStartingRounds);
        UpdateUtils.updateIfPresent(entity::getFireRateRpm,         db::setFireRateRpm);
        UpdateUtils.updateIfPresent(entity::getRecoil,              db::setRecoil);
        UpdateUtils.updateIfPresent(entity::getHorizontalRecoil,    db::setHorizontalRecoil);
        UpdateUtils.updateIfPresent(entity::getVerticalRecoil,      db::setVerticalRecoil);
        UpdateUtils.updateIfPresent(entity::getSpreadHorizontal,    db::setSpreadHorizontal);
        UpdateUtils.updateIfPresent(entity::getSpreadVertical,      db::setSpreadVertical);
        UpdateUtils.updateIfPresent(entity::getSway,                db::setSway);
        UpdateUtils.updateIfPresent(entity::getErgonomics,          db::setErgonomics);
        UpdateUtils.updateIfPresent(entity::getCapacity,            db::setCapacity);

        return entityRepository.save(db);
    }

    @Transactional
    public boolean deleteEntity(Integer stratagemId) {
        StratagemEntity entity = entityRepository.findByStratagem_StratagemId(stratagemId)
                .orElse(null);
        if (entity == null) return false;

        Stratagem stratagem = entity.getStratagem();
        stratagem.setEntity(null);
        stratagemRepository.save(stratagem);

        entityManager.flush();

        entityRepository.deleteById(entity.getEntityId());
        return true;
    }
}
