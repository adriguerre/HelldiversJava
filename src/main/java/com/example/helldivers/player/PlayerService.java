package com.example.helldivers.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Lazy
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        System.out.println("Player Service constructor");
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    //public List<Player> getPlayersFromTeam(string teamName){
        //return playerRepository.findAll().stream().
        //  filter(player -> teamName.equals(player.getTeam())).collect(Collectors.toList());
    //}

    public Player addPlayer(Player player){
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player updatedPlayer){
        Optional<Player> existingtPlayer  = playerRepository.findById(updatedPlayer.getId());

        if(existingtPlayer.isPresent()){
            Player playerToUpdate = existingtPlayer.get();
            playerToUpdate.setUsername(playerToUpdate.getUsername());

            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }

        return null;
    }


    @Transactional //maintain the data integrity during the operation
    public void deletePlayer(Long playerId){
        playerRepository.deleteById(playerId);
    }



}
