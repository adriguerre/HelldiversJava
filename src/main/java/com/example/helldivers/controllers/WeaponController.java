package com.example.helldivers.controllers;

import com.example.helldivers.domain.Account;
import com.example.helldivers.domain.Weapon;
import com.example.helldivers.enums.WeaponType;
import com.example.helldivers.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/weapons")
public class WeaponController {

    private final WeaponService weaponService;

    @Autowired
    @Lazy
    public WeaponController(WeaponService weaponService) {
        this.weaponService = weaponService;
    }


    @GetMapping
    public ResponseEntity<?> getWeapons(@RequestParam(required = false) String weapon_type){
        WeaponType type = null;
        List<Weapon> weapons = new ArrayList<>();
        if (weapon_type != null) {
            try {
                type = WeaponType.valueOf(weapon_type.toUpperCase());
            } catch (IllegalArgumentException e) {
                type = null;
            }
        }
        weapons = weaponService.getAllWeapons(type);
        if(weapons.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        return ResponseEntity.ok(weapons);
    }
}
