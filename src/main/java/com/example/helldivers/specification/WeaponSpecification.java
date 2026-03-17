package com.example.helldivers.specification;

import com.example.helldivers.domain.Weapon;
import com.example.helldivers.enums.WeaponType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class WeaponSpecification {

    public static Specification<Weapon> withFilters(WeaponType weapon_type){
        return ((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(weapon_type != null)
                predicates.add(cb.equal(root.get("weapon_type"), weapon_type));

            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }
}
