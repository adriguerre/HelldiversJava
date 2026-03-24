package com.example.helldivers.service;

import com.example.helldivers.domain.Armor;
import com.example.helldivers.domain.PassiveBonus;
import com.example.helldivers.enums.ArmorSlot;
import com.example.helldivers.repository.ArmorRepository;
import com.example.helldivers.repository.PassiveBonusRepository;
import com.example.helldivers.specification.ArmorSpecification;
import com.example.helldivers.utils.UpdateUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Component
@Lazy
public class ArmorService {

    private final ArmorRepository armorRepository;
    private final PassiveBonusRepository passiveBonusRepository;

    public ArmorService(ArmorRepository armorRepository, PassiveBonusRepository passiveBonusRepository){
        this.armorRepository = armorRepository;
        this.passiveBonusRepository = passiveBonusRepository;
    }

    public List<Armor> getAllArmors(ArmorSlot armorSlot, Integer passive_id, Boolean purchaseableArmor){
        return armorRepository.findAll(ArmorSpecification.withFilters(armorSlot, passive_id, purchaseableArmor));
    }

    public Optional<Armor> getArmorById(Integer armorId) {
        return armorRepository.findById(armorId);
    }

    public Armor createArmor(Armor armor) {
        try {
            if (armor.getPassive() != null && armor.getPassive().getPassiveId() != null) {
                PassiveBonus passive = passiveBonusRepository.findById(armor.getPassive().getPassiveId())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Passive with ID [" + armor.getPassive().getPassiveId() + "] not found"));
                armor.setPassive(passive);
            }
            return armorRepository.save(armor);
        } catch (ResponseStatusException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error creating armor");
        }
    }

    @Transactional
    public Armor updateArmor(Integer armorId, Armor armor) {
        Armor db = armorRepository.findById(armorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Armor with ID [" + armorId + "] not found"));

        UpdateUtils.updateIfPresent(armor::getName,            db::setName);
        UpdateUtils.updateIfPresent(armor::getArmorSlot,       db::setArmorSlot);
        UpdateUtils.updateIfPresent(armor::getArmorRating,     db::setArmorRating);
        UpdateUtils.updateIfPresent(armor::getSpeed,           db::setSpeed);
        UpdateUtils.updateIfPresent(armor::getStaminaRegen,    db::setStaminaRegen);
        UpdateUtils.updateIfPresent(armor::getPassive,         db::setPassive);
        UpdateUtils.updateIfPresent(armor::getReqCost,         db::setReqCost);
        UpdateUtils.updateIfPresent(armor::getSuperCreditsCost, db::setSuperCreditsCost);

        return armorRepository.save(db);
    }

    @Transactional
    public boolean deleteArmor(Integer armorId) {
        if (!armorRepository.existsById(armorId)) return false;
        armorRepository.deleteById(armorId);
        return true;
    }
}
