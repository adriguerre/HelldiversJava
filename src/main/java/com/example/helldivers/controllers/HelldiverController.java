package com.example.helldivers.controllers;

import com.example.helldivers.domain.Account;
import com.example.helldivers.domain.Helldiver;
import com.example.helldivers.service.HelldiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/helldivers")
public class HelldiverController {

    private final HelldiverService helldiverService;

    @Autowired
    @Lazy
    public HelldiverController(HelldiverService helldiverService) {
        this.helldiverService = helldiverService;
    }

    @GetMapping
    public ResponseEntity<?> getHelldivers(@RequestParam (required = false) String callsign,
                                           @RequestParam(required = false) Integer level,
                                           @RequestParam(required = false) Integer medals,
                                           @RequestParam(required = false) Integer missions,
                                           @RequestParam(required = false) Integer sc){
        List<Helldiver> helldivers =
                helldiverService.getAllHelldivers(callsign, level, medals, missions, sc);

        return ResponseEntity.ok(helldivers);
    }

    @GetMapping("/{helldiverId}")
    public ResponseEntity<?> getHelldiverByCallSign(@PathVariable Integer helldiverId){
        Optional<Helldiver> helldiver = helldiverService.getHelldiverById(helldiverId);

        if(helldiver.isPresent())
            return ResponseEntity.ok(helldiver);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Helldiver with ID: [" + helldiverId + "] not found ");
    }

    @PostMapping("/create")
    public ResponseEntity<?> createHelldiverAndLinkWithAccount(@RequestBody Helldiver helldiver){
        return ResponseEntity.ok(helldiverService.createHelldiver(helldiver));
    }

    @DeleteMapping("/delete/{helldiverId}")
    public ResponseEntity<?> deleteHelldiverById(@PathVariable Integer helldiverId) {
        Boolean deleted = helldiverService.deleteHelldiver(helldiverId);

        if (deleted) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Helldiver with ID: [" + helldiverId + "] not found ");
    }

    @PutMapping("/update/{helldiverId}")
    public ResponseEntity<?> updateHelldiverById(@PathVariable Integer helldiverId, @RequestBody Helldiver helldiver){
        Optional<Helldiver> dbHelldiver = helldiverService.getHelldiverById(helldiverId);

        if(dbHelldiver.isPresent()){
            Integer accountId = dbHelldiver.get().getAccount().getAccount_id();

            var auth = SecurityContextHolder.getContext().getAuthentication();
            if(!(auth instanceof UsernamePasswordAuthenticationToken))
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No valid token provided");

            Integer tokenAccountId = (Integer) ((UsernamePasswordAuthenticationToken) auth).getDetails();
            if(!tokenAccountId.equals(accountId))
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You can only update your own helldiver info");
        }

        Helldiver helldiver_aux = helldiverService.updateHelldiver(helldiverId, helldiver);
        return ResponseEntity.ok(helldiver_aux);
    }

}
