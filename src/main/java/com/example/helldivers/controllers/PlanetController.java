package com.example.helldivers.controllers;

import com.example.helldivers.domain.Planet;
import com.example.helldivers.service.PlanetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    private final PlanetService planetService;

    public PlanetController(PlanetService planetService){
        this.planetService = planetService;
    }

    @GetMapping()
    public ResponseEntity<?> getPlanets(){

        List<Planet> planets = planetService.getAllPlanets();

        return ResponseEntity.ok(planets);
    }
}
