package com.example.helldivers.controllers;

import com.example.helldivers.domain.Weapon;
import com.example.helldivers.enums.WeaponType;
import com.example.helldivers.service.WeaponService;
import com.example.helldivers.utils.UpdateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/{weaponId}")
    public ResponseEntity<?> getWeaponById(@PathVariable Integer weaponId) {
        return weaponService.getWeaponById(weaponId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<?> createWeapon(@RequestBody Weapon weapon) {
        Weapon created = weaponService.createWeapon(weapon);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(created.getWeaponId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{weaponId}")
    public ResponseEntity<?> updateWeapon(@PathVariable Integer weaponId, @RequestBody Weapon weapon) {
        return ResponseEntity.ok(weaponService.updateWeapon(weaponId, weapon));
    }

    @DeleteMapping("/{weaponId}")
    public ResponseEntity<?> deleteWeapon(@PathVariable Integer weaponId) {
        if (weaponService.deleteWeapon(weaponId))
            return ResponseEntity.ok("Weapon with ID [" + weaponId + "] deleted successfully");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Weapon with ID [" + weaponId + "] not found");
    }

    @GetMapping("/{weaponId}/ammo")
    public ResponseEntity<?> getAmmoByWeapon(@PathVariable Integer weaponId) {
        return ResponseEntity.ok(weaponService.getAmmoByWeapon(weaponId));
    }

    @GetMapping("/{weaponId}/attachments")
    public ResponseEntity<?> getAttachmentsByWeapon(@PathVariable Integer weaponId) {
        return ResponseEntity.ok(weaponService.getAttachmentsByWeapon(weaponId));
    }

    @GetMapping("/ammo/{ammoId}")
    public ResponseEntity<?> getWeaponsByAmmo(@PathVariable Integer ammoId) {
        List<Weapon> weapons = weaponService.getWeaponsByAmmo(ammoId);
        if (weapons.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(weapons);
    }

    @GetMapping("/attachment/{attachmentId}")
    public ResponseEntity<?> getWeaponsByAttachment(@PathVariable Integer attachmentId) {
        List<Weapon> weapons = weaponService.getWeaponsByAttachment(attachmentId);
        if (weapons.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(weapons);
    }

    @GetMapping("/{weaponId}/stats")
    public ResponseEntity<?> getWeaponStats(@PathVariable Integer weaponId) {
        return ResponseEntity.ok(weaponService.getWeaponStats(weaponId));
    }

    @PostMapping("/{weaponId}/ammo/{ammoId}")
    public ResponseEntity<?> addAmmoToWeapon(@PathVariable Integer weaponId, @PathVariable Integer ammoId) {
        return weaponService.addAmmoToWeapon(weaponId, ammoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{weaponId}/ammo/{ammoId}")
    public ResponseEntity<?> removeAmmoFromWeapon(@PathVariable Integer weaponId, @PathVariable Integer ammoId) {
        return weaponService.removeAmmoFromWeapon(weaponId, ammoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
