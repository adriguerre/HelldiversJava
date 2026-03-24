package com.example.helldivers.controllers;

import com.example.helldivers.domain.StratagemEntity;
import com.example.helldivers.service.StratagemEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stratagems/{stratagemId}/entity")
public class StratagemEntityController {

    private final StratagemEntityService entityService;

    public StratagemEntityController(StratagemEntityService entityService) {
        this.entityService = entityService;
    }

    @GetMapping
    public ResponseEntity<?> getEntityByStratagem(@PathVariable Integer stratagemId) {
        return entityService.getEntityByStratagem(stratagemId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEntity(@PathVariable Integer stratagemId,
                                           @RequestBody StratagemEntity entity) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(entityService.createEntity(stratagemId, entity));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEntity(@PathVariable Integer stratagemId,
                                           @RequestBody StratagemEntity entity) {
        return ResponseEntity.ok(entityService.updateEntity(stratagemId, entity));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEntity(@PathVariable Integer stratagemId) {
        if (entityService.deleteEntity(stratagemId))
            return ResponseEntity.ok("Entity for stratagem [" + stratagemId + "] deleted successfully");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No entity found for stratagem with ID [" + stratagemId + "]");
    }
}
