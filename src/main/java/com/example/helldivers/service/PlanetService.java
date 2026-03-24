package com.example.helldivers.service;

import com.example.helldivers.domain.Planet;
import com.example.helldivers.enums.BiomeType;
import com.example.helldivers.enums.FactionType;
import com.example.helldivers.repository.PlanetRepository;
import com.example.helldivers.specification.PlanetSpecification;
import com.example.helldivers.utils.UpdateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
public class PlanetService {

    private PlanetRepository planetRepository;

    @Autowired
    public PlanetService(PlanetRepository planetRepository){
        this.planetRepository = planetRepository;
    }

    public List<Planet> getAllPlanets(String name, String sector, Double coordinatesX, Double coordinatesY,
                                      Double maxHealth, BiomeType biomeType, FactionType factionType){
        return planetRepository.findAll(PlanetSpecification.withFilters(name, sector, coordinatesX,
                coordinatesY, maxHealth, biomeType, factionType));
    }

    public Optional<Planet> getPlanetById(Integer planetId){
        return planetRepository.findById(planetId);
    }

    public Boolean createPlanet(Planet planet){
        try {
            planetRepository.save(planet);
        } catch (Exception ex) {
            System.out.println("ERROR ON PLANET CREATION: " + ex.getMessage());
            return false;
        }
        return true;
    }

    public Boolean deletePlanet(Integer planetId){
        try {
            planetRepository.deleteById(planetId);
        } catch (Exception ex) {
            System.out.println("ERROR ON PLANET DELETION: " + ex.getMessage());
            return false;
        }
        return true;
    }

    @Transactional
    public Planet updatePlanet(Integer planetId, Planet planet){
        Planet db = planetRepository.findById(planetId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Planet with ID [" + planetId + "] not found"));

        UpdateUtils.updateIfPresent(planet::getName,           db::setName);
        UpdateUtils.updateIfPresent(planet::getSector,         db::setSector);
        UpdateUtils.updateIfPresent(planet::getLiberationRate, db::setLiberationRate);
        UpdateUtils.updateIfPresent(planet::getCoordinatesX,   db::setCoordinatesX);
        UpdateUtils.updateIfPresent(planet::getCoordinatesY,   db::setCoordinatesY);
        UpdateUtils.updateIfPresent(planet::getMaxHealth,      db::setMaxHealth);
        UpdateUtils.updateIfPresent(planet::getCurrentHealth,  db::setCurrentHealth);
        UpdateUtils.updateIfPresent(planet::getRegenPerHour,   db::setRegenPerHour);
        UpdateUtils.updateIfPresent(planet::getBiome,          db::setBiome);
        UpdateUtils.updateIfPresent(planet::getOwnerFaction,   db::setOwnerFaction);
        UpdateUtils.updateIfPresent(planet::getHazardTypes,    db::setHazardTypes);

        return planetRepository.save(db);
    }
}
