package com.example.helldivers.specification;

import com.example.helldivers.domain.Account;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class AccountSpecification {

    public static Specification<Account> withFilters(String region, String platformType, Boolean isBanned){
        return ((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(region != null)
                predicates.add(cb.equal(root.get("region"), region));

            if (platformType != null)
                predicates.add(cb.equal(root.get("platform_type"), platformType));

            if (isBanned != null)
                predicates.add(cb.equal(root.get("is_banned"), isBanned));

            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }
}
