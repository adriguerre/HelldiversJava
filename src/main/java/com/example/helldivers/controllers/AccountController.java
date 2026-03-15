package com.example.helldivers.controllers;

import com.example.helldivers.domain.Account;
import com.example.helldivers.domain.Helldiver;
import com.example.helldivers.service.AccountService;
import com.example.helldivers.service.HelldiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<?> getAccounts(){
        List<Account> accounts = accountService.getAllAccounts();

        return ResponseEntity.ok(accounts);
    }
}
