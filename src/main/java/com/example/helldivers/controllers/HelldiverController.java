package com.example.helldivers.controllers;

import com.example.helldivers.domain.Helldiver;
import com.example.helldivers.player.Player;
import com.example.helldivers.service.HelldiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/helldiver")
public class HelldiverController {

    private final HelldiverService helldiverService;

    @Autowired
    @Lazy
    public HelldiverController(HelldiverService helldiverService) {
        this.helldiverService = helldiverService;
    }

    @GetMapping
    public ResponseEntity<?> getHelldivers(){
        List<Helldiver> helldivers = helldiverService.getAllHelldivers();

        return ResponseEntity.ok(helldivers);
    }
}
