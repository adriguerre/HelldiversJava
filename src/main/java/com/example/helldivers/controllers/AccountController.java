package com.example.helldivers.controllers;

import com.example.helldivers.DTO.LoginRequest;
import com.example.helldivers.domain.Account;
import com.example.helldivers.domain.Helldiver;
import com.example.helldivers.service.AccountService;
import com.example.helldivers.service.HelldiverService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    @Lazy
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping
    public ResponseEntity<?> getAccounts(
            @RequestParam(required = false) String region,
            @RequestParam(required = false) String platform_type,
            @RequestParam(required = false) Boolean is_banned) {

        List<Account> accounts = accountService.getAccountsFiltered(region, platform_type, is_banned);

        if (accounts.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<?> getAccountById(@PathVariable Integer accountId){
        Optional<Account> account = accountService.getAccountById(accountId);

        if(account.isPresent())
            return ResponseEntity.ok(account);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account with ID: [" + accountId + "] not found ");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String token = accountService.login(loginRequest.getEmail(), loginRequest.getPassword());

        if (token != null)
            return ResponseEntity.ok(Map.of("token", token));
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
    }

    @PostMapping("/register")
    public ResponseEntity<?> createAccount(@RequestBody @Valid Account account){

        accountService.createOrModifyNewAccount(account);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{account_id}").buildAndExpand(account.getAccount_id()).toUri();

        return ResponseEntity.created(location).body(account);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<?> updateAccount(@PathVariable Integer accountId, @RequestBody Account account) {
        account.setAccount_id(accountId);
        Account updated = accountService.createOrModifyNewAccount(account);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{accountId}")
    public ResponseEntity<?> deleteAccountById(@PathVariable Integer accountId){
        Boolean accountDeleted = accountService.deleteAccountById(accountId);

        if (accountDeleted)
            return ResponseEntity.ok("Account with ID: [" + accountId + "] deleted successfully");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account with ID: [" + accountId + "] not found");
    }
}
