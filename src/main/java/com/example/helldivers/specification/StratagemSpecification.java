package com.example.helldivers.specification;


import com.example.helldivers.domain.Stratagem;
import com.example.helldivers.enums.StratagemType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class StratagemSpecification {

    public static Specification<Stratagem> withFilters(String name, Boolean backpack_slot, Integer usesPerMission,
                                                       StratagemType stratagem_type){
        return ((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(name != null)
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));

            if(backpack_slot != null)
                predicates.add(cb.equal(root.get("backpackSlot"), backpack_slot));

            if(usesPerMission != null)
                   predicates.add(cb.equal(root.get("usesPerMission"), usesPerMission));

            if(stratagem_type != null){
                predicates.add(cb.equal(root.get("category"), stratagem_type));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        });

    }
}
