package com.example.helldivers.service;

import com.example.helldivers.domain.Weapon;
import com.example.helldivers.enums.WeaponType;
import com.example.helldivers.repository.WeaponRepository;
import com.example.helldivers.specification.WeaponSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
public class WeaponService {

    private WeaponRepository weaponRepository;

    public WeaponService(WeaponRepository weaponRepository){
        this.weaponRepository = weaponRepository;
    }

    public List<Weapon> getAllWeapons(WeaponType weaponType){
        return weaponRepository.findAll(WeaponSpecification.withFilters(weaponType));
    }
}
