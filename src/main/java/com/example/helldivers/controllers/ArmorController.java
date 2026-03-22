package com.example.helldivers.controllers;

import com.example.helldivers.domain.Armor;
import com.example.helldivers.enums.ArmorSlot;
import com.example.helldivers.service.ArmorService;
import com.example.helldivers.utils.UpdateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/armor")
public class ArmorController {

    private final ArmorService armorService;

    public ArmorController(ArmorService armorService) {
        this.armorService = armorService;
    }

    @GetMapping
    public ResponseEntity<?> getArmor(@RequestParam(required = false) String armor_slot,
                                      @RequestParam(required = false) Integer passive_id,
                                      @RequestParam(required = false) Boolean shop){

        List<Armor> armorList = armorService.getAllArmors(UpdateUtils.parseEnum(ArmorSlot.class, armor_slot), passive_id, shop);

        if(armorList.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        return ResponseEntity.ok(armorList);
    }
}
