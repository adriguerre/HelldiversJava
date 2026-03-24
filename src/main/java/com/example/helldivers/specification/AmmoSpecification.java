package com.example.helldivers.specification;

import com.example.helldivers.domain.Ammo;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AmmoSpecification {
    public static Specification<Ammo> withFilters(String caliber, String pen){
        return ((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(caliber != null)
                predicates.add(cb.like(cb.lower(root.get("caliber")), "%" + caliber.toLowerCase() + "%"));

            if(pen != null)
                predicates.add(cb.equal(cb.lower(root.get("penetrationDirectName")), pen.toLowerCase()));


            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }
}
