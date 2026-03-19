package com.example.helldivers.specification;

import com.example.helldivers.domain.Helldiver;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class HelldiverSpecification {
    public static Specification<Helldiver> withFilters(String callSign, Integer level, Integer medals,
                                                       Integer missionCompleted, Integer superCredits){

        return ((root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(callSign != null)
                predicates.add(cb.like(cb.lower(root.get("callSign")), "%" + callSign.toLowerCase() + "%"));

            if(level != null)
                predicates.add(cb.equal(root.get("level"), level));

            if(medals != null)
                predicates.add(cb.equal(root.get("medals"), medals));

            if(missionCompleted != null)
                predicates.add(cb.equal(root.get("missionsCompleted"), missionCompleted));

            if(superCredits != null)
                predicates.add(cb.equal(root.get("super_credits"), superCredits));


            return cb.and(predicates.toArray(new Predicate[0]));
        });

    }
}
