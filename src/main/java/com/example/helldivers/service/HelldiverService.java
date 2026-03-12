package com.example.helldivers.service;

import com.example.helldivers.domain.Helldiver;
import com.example.helldivers.player.Player;
import com.example.helldivers.repository.HelldiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
public class HelldiverService {


    private HelldiverRepository helldiverRepository;

    @Autowired
    public HelldiverService(HelldiverRepository helldiverRepository){
        System.out.println("Helldiver Service constructor");

        this.helldiverRepository = helldiverRepository;
    }

    public List<Helldiver> getAllHelldivers(){
        return helldiverRepository.findAll();
    }
}
