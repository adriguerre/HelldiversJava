package com.example.helldivers.service;

import com.example.helldivers.domain.Helldiver;
import com.example.helldivers.repository.HelldiverRepository;
import com.example.helldivers.specification.HelldiverSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Component
@Lazy
public class HelldiverService {


    private HelldiverRepository helldiverRepository;

    @Autowired
    public HelldiverService(HelldiverRepository helldiverRepository){
        System.out.println("Helldiver Service constructor");

        this.helldiverRepository = helldiverRepository;
    }

    public List<Helldiver> getAllHelldivers(String callSign, Integer level,
                                            Integer medals, Integer missionsCompleted, Integer superCredits){

        return helldiverRepository.findAll(HelldiverSpecification.withFilters(callSign, level, medals,
                missionsCompleted, superCredits));
    }

    public Optional<Helldiver> getHelldiverByCallSign(String callSign){
        return helldiverRepository.findByCallSign(callSign);
    }

    public Optional<Helldiver> getHelldiverById(Long helldiverId){
        return helldiverRepository.findByHelldiverId(helldiverId);
    }
}
