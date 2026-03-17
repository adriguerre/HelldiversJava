package com.example.helldivers.service;

import com.example.helldivers.DTO.LoginRequest;
import com.example.helldivers.domain.Account;
import com.example.helldivers.domain.AccountRole;
import com.example.helldivers.domain.Role;
import com.example.helldivers.repository.AccountRepository;
import com.example.helldivers.repository.AccountRoleRepository;
import com.example.helldivers.repository.RoleRepository;
import com.example.helldivers.security.JwtUtil;
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

    private AccountRepository accountRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AccountRoleRepository accountRoleRepository;


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

    public Account createOrModifyNewAccount(Account account) {
        if (account.getPassword() != null)
            account.setPassword(passwordEncoder.encode(account.getPassword()));

        Account saved = accountRepository.save(account);

        Role userRole = roleRepository.findByName("USER");
        AccountRole accountRole = new AccountRole(saved.getAccount_id().longValue(), userRole.getRole_id());
        accountRoleRepository.save(accountRole);

        return saved;
    }

    public String login(String email, String password) {
        Optional<Account> account = accountRepository.findByEmail(email);

        if (account.isPresent() && passwordEncoder.matches(password, account.get().getPassword())) {
            // Buscar el rol del usuario
            AccountRole accountRole = accountRoleRepository.findByAccountId(account.get().getAccount_id().longValue());
            Role role = roleRepository.findById(accountRole.getRoleId()).orElse(null);
            String roleName = role != null ? role.getName() : "USER";

            return jwtUtil.generateToken(email, roleName);
        }

        return null;
    }


    public Boolean deleteAccountById(Integer accountId){
        if (accountRepository.existsById(accountId)) {
            accountRepository.deleteById(accountId);
            return true;
        }
        return false;
    }


}
