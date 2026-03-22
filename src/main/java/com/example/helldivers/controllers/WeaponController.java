package com.example.helldivers.controllers;

import com.example.helldivers.domain.Weapon;
import com.example.helldivers.enums.WeaponType;
import com.example.helldivers.service.WeaponService;
import com.example.helldivers.utils.UpdateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        List<Weapon> weapons = weaponService.getAllWeapons(UpdateUtils.parseEnum(WeaponType.class, weapon_type));
        if(weapons.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        return ResponseEntity.ok(weapons);
    }
}
