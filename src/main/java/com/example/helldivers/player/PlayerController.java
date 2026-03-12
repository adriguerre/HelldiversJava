package com.example.helldivers.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    @Lazy
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        System.out.println("Player Controller constructor");

        this.playerService = playerService;
    }


    @GetMapping
    public ResponseEntity<?> getPlayers(){
        List<Player> players = playerService.getPlayers();

        return ResponseEntity.ok(players);
    }
}
