package com.example.helldivers.controllers;

import com.example.helldivers.domain.Armor;
import com.example.helldivers.enums.ArmorSlot;
import com.example.helldivers.service.ArmorService;
import com.example.helldivers.utils.UpdateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
                                      @RequestParam(required = false) Boolean shop) {
        List<Armor> armorList = armorService.getAllArmors(UpdateUtils.parseEnum(ArmorSlot.class, armor_slot), passive_id, shop);
        if (armorList.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(armorList);
    }

    @GetMapping("/{armorId}")
    public ResponseEntity<?> getArmorById(@PathVariable Integer armorId) {
        return armorService.getArmorById(armorId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("")
    public ResponseEntity<?> createArmor(@RequestBody Armor armor) {
        Armor created = armorService.createArmor(armor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(created.getArmorId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{armorId}")
    public ResponseEntity<?> updateArmor(@PathVariable Integer armorId, @RequestBody Armor armor) {
        return ResponseEntity.ok(armorService.updateArmor(armorId, armor));
    }

    @DeleteMapping("/{armorId}")
    public ResponseEntity<?> deleteArmor(@PathVariable Integer armorId) {
        if (armorService.deleteArmor(armorId))
            return ResponseEntity.ok("Armor with ID [" + armorId + "] deleted successfully");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Armor with ID [" + armorId + "] not found");
    }
}
