package com.example.helldivers.service;

import com.example.helldivers.domain.Stratagem;
import com.example.helldivers.enums.StratagemType;
import com.example.helldivers.repository.StratagemRepository;
import com.example.helldivers.specification.StratagemSpecification;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StratagemService {

    private StratagemRepository stratagemRepository;


    public StratagemService(StratagemRepository stratagemRepository){
        this.stratagemRepository = stratagemRepository;
    }

    public List<Stratagem> getStratagems(String name, Boolean backpack_slot, Integer uses_per_mission, StratagemType stratagem_type){
        return stratagemRepository.findAll(StratagemSpecification.withFilters(name, backpack_slot, uses_per_mission,
                stratagem_type));
    }

    public Optional<Stratagem> getStratagemById(Integer stratagem_id){
        return stratagemRepository.findById(stratagem_id);
    }

}
