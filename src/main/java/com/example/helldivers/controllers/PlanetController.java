package com.example.helldivers.controllers;

import com.example.helldivers.domain.Planet;
import com.example.helldivers.enums.BiomeType;
import com.example.helldivers.enums.FactionType;
import com.example.helldivers.service.PlanetService;
import com.example.helldivers.utils.UpdateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    private final PlanetService planetService;

    public PlanetController(PlanetService planetService){
        this.planetService = planetService;
    }

    @GetMapping()
    public ResponseEntity<?> getPlanets(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) String sector,
                                        @RequestParam(required = false) Double cordX,
                                        @RequestParam(required = false) Double cordY,
                                        @RequestParam(required = false) Double maxhp,
                                        @RequestParam(required = false) String biome,
                                        @RequestParam(required = false) String faction){

        List<Planet> planets =
                planetService.getAllPlanets(name, sector, cordX, cordY, maxhp,
                        UpdateUtils.parseEnum(BiomeType.class, biome),
                        UpdateUtils.parseEnum(FactionType.class, faction));

        return ResponseEntity.ok(planets);
    }

    @GetMapping("/{planetId}")
    public ResponseEntity<?> getPlanetById(@PathVariable Integer planetId){
        Optional<Planet> planet = planetService.getPlanetById(planetId);

        if (planet.isPresent())
            return ResponseEntity.ok(planet);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No planet found with ID [" + planetId + "]");
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPlanet(@RequestBody Planet planet){
        Boolean planetCreated = planetService.createPlanet(planet);

        if (planetCreated)
            return ResponseEntity.status(HttpStatus.CREATED).body(planet);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(planet);
    }

    @DeleteMapping("/delete/{planetId}")
    public ResponseEntity<?> deletePlanetById(@PathVariable Integer planetId){
        Boolean planetDeleted = planetService.deletePlanet(planetId);

        if (planetDeleted)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Planet with ID [" + planetId + "] deleted successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Planet with ID [" + planetId + "] couldn't be deleted");
    }

    @PutMapping("/update/{planetId}")
    public ResponseEntity<?> updatePlanetById(@PathVariable Integer planetId, @RequestBody Planet planet){
        return ResponseEntity.ok(planetService.updatePlanet(planetId, planet));
    }
}
