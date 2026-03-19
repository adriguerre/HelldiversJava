package com.example.helldivers.controllers;

import com.example.helldivers.domain.Helldiver;
import com.example.helldivers.service.HelldiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/helldivers")
public class HelldiverController {

    private final HelldiverService helldiverService;

    @Autowired
    @Lazy
    public HelldiverController(HelldiverService helldiverService) {
        this.helldiverService = helldiverService;
    }

    @GetMapping
    public ResponseEntity<?> getHelldivers(@RequestParam (required = false) String callsign,
                                           @RequestParam(required = false) Integer level,
                                           @RequestParam(required = false) Integer medals,
                                           @RequestParam(required = false) Integer missions,
                                           @RequestParam(required = false) Integer sc){
        List<Helldiver> helldivers =
                helldiverService.getAllHelldivers(callsign, level, medals, missions, sc);

        return ResponseEntity.ok(helldivers);
    }


    @GetMapping("/{helldiverId}")
    public ResponseEntity<?> getHelldiverByCallSign(@PathVariable Long helldiverId){
        Optional<Helldiver> helldiver = helldiverService.getHelldiverById(helldiverId);

        if(helldiver.isPresent())
            return ResponseEntity.ok(helldiver);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Helldiver with ID: [" + helldiverId + "] not found ");
    }

}
