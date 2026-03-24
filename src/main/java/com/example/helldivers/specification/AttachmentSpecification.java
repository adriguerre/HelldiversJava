package com.example.helldivers.specification;

import com.example.helldivers.domain.Attachment;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AttachmentSpecification {

    public static Specification<Attachment> withFilters(String category) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (category != null)
                predicates.add(cb.like(cb.lower(root.get("category")), "%" + category.toLowerCase() + "%"));

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
