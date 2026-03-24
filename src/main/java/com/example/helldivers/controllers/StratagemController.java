package com.example.helldivers.controllers;

import com.example.helldivers.domain.Stratagem;
import com.example.helldivers.enums.StratagemType;
import com.example.helldivers.service.StratagemService;
import com.example.helldivers.utils.UpdateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/stratagems")
public class StratagemController {

    private final StratagemService stratagemService;

    public StratagemController(StratagemService stratagemService) {
        this.stratagemService = stratagemService;
    }

    @GetMapping
    public ResponseEntity<?> getStratagems(@RequestParam(required = false) String name,
                                           @RequestParam(required = false) Boolean backpack,
                                           @RequestParam(required = false) Integer uses,
                                           @RequestParam(required = false) String type) {
        List<Stratagem> stratagems = stratagemService.getStratagems(name, backpack, uses, UpdateUtils.parseEnum(StratagemType.class, type));
        if (stratagems.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(stratagems);
    }

    @GetMapping("/{stratagemId}")
    public ResponseEntity<?> getStratagemById(@PathVariable Integer stratagemId) {
        return stratagemService.getStratagemById(stratagemId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStratagem(@RequestBody Stratagem stratagem) {
        Stratagem created = stratagemService.createStratagem(stratagem);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(created.getStratagemId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/update/{stratagemId}")
    public ResponseEntity<?> updateStratagem(@PathVariable Integer stratagemId, @RequestBody Stratagem stratagem) {
        return ResponseEntity.ok(stratagemService.updateStratagem(stratagemId, stratagem));
    }

    @DeleteMapping("/delete/{stratagemId}")
    public ResponseEntity<?> deleteStratagem(@PathVariable Integer stratagemId) {
        if (stratagemService.deleteStratagem(stratagemId))
            return ResponseEntity.ok("Stratagem with ID [" + stratagemId + "] deleted successfully");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Stratagem with ID [" + stratagemId + "] not found");
    }
}
