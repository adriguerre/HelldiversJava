package com.example.helldivers.controllers;

import com.example.helldivers.domain.Stratagem;
import com.example.helldivers.enums.StratagemType;
import com.example.helldivers.service.StratagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stratagems")
public class StratagemController {


    private final StratagemService stratagemService;

    @Autowired
    @Lazy
    public StratagemController(StratagemService stratagemService) {
        this.stratagemService = stratagemService;
    }

    @GetMapping
    public ResponseEntity<?> getStratagems(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) Boolean backpack,
                                        @RequestParam(required = false) Integer uses,
                                        @RequestParam(required = false) String type){

        StratagemType stratagemType = null;
        List<Stratagem> stratagems = new ArrayList<>();

        if(type != null){
            try{
                   stratagemType = StratagemType.valueOf(type.toUpperCase());
            }catch(IllegalArgumentException e){
                    stratagemType = null;
            }
        }

        stratagems = stratagemService.getStratagems(name, backpack, uses, stratagemType);
        if(stratagems.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }


        return ResponseEntity.ok(stratagems);
    }

    @GetMapping("{stratagem_id}")
    public ResponseEntity<?> getStratagemById(@PathVariable Integer stratagem_id){
        Optional<Stratagem> stratagem = stratagemService.getStratagemById(stratagem_id);

        if(stratagem.isPresent())
            return ResponseEntity.ok(stratagem);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
