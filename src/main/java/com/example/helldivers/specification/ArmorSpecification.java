package com.example.helldivers.specification;

import com.example.helldivers.domain.Armor;
import com.example.helldivers.enums.ArmorSlot;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ArmorSpecification {

    public static Specification<Armor> withFilters(ArmorSlot armor_slot, Integer passive_id){
        return((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(armor_slot != null)
                predicates.add(cb.equal(root.get("armor_slot"), armor_slot));

            if(passive_id != null)
                predicates.add(cb.equal(root.get("passive_id"), passive_id));

            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }
}
