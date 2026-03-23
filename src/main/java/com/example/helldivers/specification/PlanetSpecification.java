package com.example.helldivers.specification;

import com.example.helldivers.domain.Planet;
import com.example.helldivers.enums.BiomeType;
import com.example.helldivers.enums.FactionType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PlanetSpecification{
    public static Specification<Planet> withFilters(String name, String sector, Double coordinatesX,
                                                   Double coordinatesY, Double maxHealth, BiomeType biomeType,
                                                   FactionType ownerFaction){
        return ((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(name != null)
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));

            if(sector != null)
                predicates.add(cb.like(cb.lower(root.get("sector")), "%" + sector.toLowerCase() + "%"));

            if(coordinatesX != null)
                predicates.add(cb.equal(root.get("coordinatesX"), coordinatesX));

            if(coordinatesY != null)
                predicates.add(cb.equal(root.get("coordinatesY"), coordinatesY));

            if(maxHealth != null)
                predicates.add(cb.equal(root.get("maxHealth"), maxHealth));

            if(biomeType != null)
                predicates.add(cb.equal(root.get("biome"), biomeType));

            if(ownerFaction != null)
                predicates.add(cb.equal(root.get("ownerFaction"), ownerFaction));

            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }
}
