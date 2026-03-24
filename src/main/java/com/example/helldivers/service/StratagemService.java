package com.example.helldivers.service;

import com.example.helldivers.domain.Stratagem;
import com.example.helldivers.enums.StratagemType;
import com.example.helldivers.repository.StratagemRepository;
import com.example.helldivers.specification.StratagemSpecification;
import com.example.helldivers.utils.UpdateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StratagemService {

    private final StratagemRepository stratagemRepository;

    public StratagemService(StratagemRepository stratagemRepository){
        this.stratagemRepository = stratagemRepository;
    }

    public List<Stratagem> getStratagems(String name, Boolean backpack_slot, Integer uses_per_mission, StratagemType stratagem_type){
        return stratagemRepository.findAll(StratagemSpecification.withFilters(name, backpack_slot, uses_per_mission, stratagem_type));
    }

    public Optional<Stratagem> getStratagemById(Integer stratagem_id){
        return stratagemRepository.findById(stratagem_id);
    }

    public Stratagem createStratagem(Stratagem stratagem) {
        try {
            return stratagemRepository.save(stratagem);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error creating stratagem");
        }
    }

    @Transactional
    public Stratagem updateStratagem(Integer stratagemId, Stratagem stratagem) {
        Stratagem db = stratagemRepository.findById(stratagemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Stratagem with ID [" + stratagemId + "] not found"));

        UpdateUtils.updateIfPresent(stratagem::getName,             db::setName);
        UpdateUtils.updateIfPresent(stratagem::getCategory,         db::setCategory);
        UpdateUtils.updateIfPresent(stratagem::getInputSequence,    db::setInputSequence);
        UpdateUtils.updateIfPresent(stratagem::getUsesPerMission,   db::setUsesPerMission);
        UpdateUtils.updateIfPresent(stratagem::getCooldownSeconds,  db::setCooldownSeconds);
        UpdateUtils.updateIfPresent(stratagem::getActivationTime,   db::setActivationTime);
        UpdateUtils.updateIfPresent(stratagem::getDamage,           db::setDamage);
        UpdateUtils.updateIfPresent(stratagem::getRadius,           db::setRadius);
        UpdateUtils.updateIfPresent(stratagem::getReqCost,          db::setReqCost);
        UpdateUtils.updateIfPresent(stratagem::getUnlockLevel,      db::setUnlockLevel);
        UpdateUtils.updateIfPresent(stratagem::getBackpackSlot,     db::setBackpackSlot);

        return stratagemRepository.save(db);
    }

    @Transactional
    public boolean deleteStratagem(Integer stratagemId) {
        if (!stratagemRepository.existsById(stratagemId)) return false;
        stratagemRepository.deleteById(stratagemId);
        return true;
    }
}
