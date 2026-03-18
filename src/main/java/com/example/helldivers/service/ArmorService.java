package com.example.helldivers.service;

import com.example.helldivers.domain.Armor;
import com.example.helldivers.enums.ArmorSlot;
import com.example.helldivers.repository.ArmorRepository;
import com.example.helldivers.specification.WeaponSpecification;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.example.helldivers.specification.ArmorSpecification;

import java.util.List;

@Component
@Lazy
public class ArmorService {

    private ArmorRepository armorRepository;

    public ArmorService(ArmorRepository armorRepository){
        this.armorRepository = armorRepository;
    }

    public List<Armor> getAllArmors(ArmorSlot armorSlot, Integer passive_id, Boolean purchaseableArmor){
        return armorRepository.findAll(ArmorSpecification.withFilters(armorSlot, passive_id, purchaseableArmor));
    }


}
