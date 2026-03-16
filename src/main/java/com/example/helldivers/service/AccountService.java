package com.example.helldivers.service;

import com.example.helldivers.DTO.LoginRequest;
import com.example.helldivers.domain.Account;
import com.example.helldivers.repository.AccountRepository;
import com.example.helldivers.specification.AccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Component
@Lazy
public class AccountService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private AccountRepository accountRepository;


    @Autowired
    public AccountService(AccountRepository accountRepository){
        System.out.println("Helldiver Service constructor");

        this.accountRepository = accountRepository;
    }

    public List<Account> getAccountsFiltered(String region, String platformType, Boolean isBanned) {
        return accountRepository.findAll(
                AccountSpecification.withFilters(region, platformType, isBanned)
        );
    }
    public Optional<Account> getAccountById(Integer id){
        return accountRepository.findById(id);
    }

    public Account createOrModifyNewAccount(Account account){
        if (account.getPassword() != null)
            account.setPassword(passwordEncoder.encode(account.getPassword()));

        accountRepository.save(account);
        return account;
    }

    public boolean login(String email, String password) {
        Optional<Account> account = accountRepository.findByEmail(email);

        System.out.println(password);
        if (account.isPresent())
            return passwordEncoder.matches(password, account.get().getPassword());

        return false;
    }


    public Boolean deleteAccountById(Integer accountId){
        if (accountRepository.existsById(accountId)) {
            accountRepository.deleteById(accountId);
            return true;
        }
        return false;
    }


}
