package com.example.helldivers.service;

import com.example.helldivers.domain.Account;
import com.example.helldivers.domain.Helldiver;
import com.example.helldivers.repository.AccountRepository;
import com.example.helldivers.repository.HelldiverRepository;
import com.example.helldivers.specification.HelldiverSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.stream;

@Component
@Lazy
public class HelldiverService {


    private HelldiverRepository helldiverRepository;
    private AccountRepository accountRepository;

    @Autowired
    public HelldiverService(HelldiverRepository helldiverRepository, AccountRepository accountRepository){
        System.out.println("Helldiver Service constructor");

        this.accountRepository = accountRepository;
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

    public Optional<Helldiver> getHelldiverById(Integer helldiverId){
        return helldiverRepository.findByHelldiverId(helldiverId);
    }

    public Map<String, Object> createHelldiver(Helldiver helldiver){

        if(helldiver.getAccount() == null || helldiver.getAccount().getAccount_id() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Account to link with — send: \"account\": { \"account_id\": 30 }");
        }
        System.out.println("CHECKING");
        Optional<Account> account = accountRepository.findById(helldiver.getAccount().getAccount_id());
        System.out.println("ACCOUNT ID: " + helldiver.getAccount().getAccount_id());
        Optional<Helldiver> helldiverDB = helldiverRepository.findByAccountId(helldiver.getAccount().getAccount_id());
        System.out.println(helldiverDB.isPresent());

        if(helldiverDB.isPresent()){
            System.out.println(helldiverDB.get().getAccount());
            System.out.println("CHECKED");
            if(helldiverDB.get().getAccount() != null){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account already linked to other helldiver");

            }
        }

        if(!account.isPresent()){
            List<Integer> accountIdsList = accountRepository.findAllAccountIds();
            List<Integer> helldiversWithAccount = helldiverRepository.findAll().stream()
                    .map(Helldiver::getAccount)
                    .filter(a -> a != null)
                    .map(Account::getAccount_id)
                    .toList();

            for(Integer accountId : helldiversWithAccount){
                if(accountIdsList.contains(accountId))
                    accountIdsList.remove(accountId);
            }

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, Map.of("empty_accounts", accountIdsList).toString());
        }

        helldiverRepository.save(helldiver);

        return Map.of(
                "message", "Helldiver created and linked with account",
                "helldiver", helldiver,
                "linked_with", helldiver.getAccount().getAccount_id()
        );
    }


    @org.springframework.transaction.annotation.Transactional
    public Boolean deleteHelldiver(Integer helldiverId){
        if (helldiverRepository.existsById(helldiverId)) {
            helldiverRepository.deleteByHelldiverId(helldiverId);
            return true;
        }
        return false;
    }
}
