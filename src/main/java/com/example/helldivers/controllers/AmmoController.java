package com.example.helldivers.controllers;

import com.example.helldivers.domain.Account;
import com.example.helldivers.domain.Ammo;
import com.example.helldivers.domain.Planet;
import com.example.helldivers.service.AmmoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/ammo")
public class AmmoController {

    private final AmmoService ammoService;

    public AmmoController(AmmoService ammoService) {
        this.ammoService = ammoService;
    }


    @GetMapping
    public ResponseEntity<?> getAmmo(@RequestParam(required = false) String caliber,
                                     @RequestParam(required = false) String pen){
        List<Ammo> ammoList = ammoService.getAmmoWithParams(caliber, pen);

        if(ammoList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No ammo found");
        }else
            return ResponseEntity.ok(ammoList);
    }

    @GetMapping("/{ammoId}")
    public ResponseEntity<?> getAmmoById(@PathVariable Integer ammoId){
        Optional<Ammo> ammo = ammoService.getAmmoById(ammoId);

        if(ammo.isPresent())
            return ResponseEntity.ok(ammo);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ammo with ID [" + ammoId + "] not found");
    }

    @PostMapping("")
    public ResponseEntity<?> createAmmo(@RequestBody Ammo ammo){
        Ammo ammoCreated = ammoService.createAmmo(ammo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ammo_id}").buildAndExpand(ammoCreated.getAmmoId()).toUri();
        return ResponseEntity.created(location).body(ammoCreated);
    }

    @DeleteMapping("/{ammoId}")
    public ResponseEntity<?> deleteAmmo(@PathVariable Integer ammoId){
        Boolean ammoDeleted = ammoService.deleteAmmoById(ammoId);

        if (ammoDeleted)
            return ResponseEntity.ok("Ammo with ID: [" + ammoId + "] deleted successfully");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ammo with ID: [" + ammoId + "] not found");
    }

    @PutMapping("/{ammoId}")
    public ResponseEntity<?> updateAmmoById(@PathVariable Integer ammoId, @RequestBody Ammo ammo){
        return ResponseEntity.ok(ammoService.updateAmmo(ammoId, ammo));
    }
}
