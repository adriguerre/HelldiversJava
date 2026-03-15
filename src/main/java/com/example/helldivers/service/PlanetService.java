package com.example.helldivers.service;

import com.example.helldivers.domain.Planet;
import com.example.helldivers.repository.PlanetRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
public class PlanetService {

    private PlanetRepository planetRepository;


    public PlanetService(PlanetRepository planetRepository){
        this.planetRepository = planetRepository;
    }


    public List<Planet> getAllPlanets(){
        return planetRepository.findAll();
    }
}
