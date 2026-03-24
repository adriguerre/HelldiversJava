package com.example.helldivers.controllers;

import com.example.helldivers.domain.StratagemAttack;
import com.example.helldivers.service.StratagemAttackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/stratagems/{stratagemId}/attacks")
public class StratagemAttackController {

    private final StratagemAttackService attackService;

    public StratagemAttackController(StratagemAttackService attackService) {
        this.attackService = attackService;
    }

    @GetMapping
    public ResponseEntity<?> getAttacksByStratagem(@PathVariable Integer stratagemId) {
        List<StratagemAttack> attacks = attackService.getAttacksByStratagem(stratagemId);
        if (attacks.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(attacks);
    }

    @GetMapping("/{attackId}")
    public ResponseEntity<?> getAttackById(@PathVariable Integer stratagemId,
                                            @PathVariable Integer attackId) {
        return attackService.getAttackById(attackId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("")
    public ResponseEntity<?> createAttack(@PathVariable Integer stratagemId,
                                           @RequestBody StratagemAttack attack) {
        StratagemAttack created = attackService.createAttack(stratagemId, attack);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(created.getAttackId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{attackId}")
    public ResponseEntity<?> updateAttack(@PathVariable Integer stratagemId,
                                           @PathVariable Integer attackId,
                                           @RequestBody StratagemAttack attack) {
        return ResponseEntity.ok(attackService.updateAttack(attackId, attack));
    }

    @DeleteMapping("/{attackId}")
    public ResponseEntity<?> deleteAttack(@PathVariable Integer stratagemId,
                                           @PathVariable Integer attackId) {
        if (attackService.deleteAttack(attackId))
            return ResponseEntity.ok("Attack with ID [" + attackId + "] deleted successfully");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Attack with ID [" + attackId + "] not found");
    }
}
