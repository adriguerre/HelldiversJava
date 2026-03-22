package com.example.helldivers.specification;

import com.example.helldivers.domain.Mission;
import com.example.helldivers.enums.FactionType;
import com.example.helldivers.enums.MissionType;
import com.example.helldivers.enums.ResultType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class MissionSpecification {

    public static Specification<Mission> withFilters(MissionType missionType, Integer difficulty,
                                                     FactionType enemyFaction, Boolean inProgress, Boolean started,
                                                     Boolean ended, ResultType missionResult,
                                                     Boolean missionStatsSaved) {
        return ((root, query, cb ) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(missionType != null)
                predicates.add(cb.equal(root.get("missionType"), missionType));

            if(difficulty != null)
                predicates.add(cb.equal(root.get("difficulty"), difficulty));

            if(enemyFaction != null)
                predicates.add(cb.equal(root.get("enemyFaction"), enemyFaction));

            if (inProgress != null)
                predicates.add(inProgress
                        ? cb.and(cb.isNotNull(root.get("startedAt")), cb.isNull(root.get("endedAt")))
                        : cb.or(cb.isNull(root.get("startedAt")), cb.isNotNull(root.get("endedAt"))));

            if (started != null)
                predicates.add(started ? cb.isNotNull(root.get("startedAt")) : cb.isNull(root.get("startedAt")));

            if (ended != null)
                predicates.add(ended ? cb.isNotNull(root.get("endedAt")) : cb.isNull(root.get("endedAt")));

            if (missionResult != null)
                predicates.add(cb.equal(root.get("missionResult"), missionResult));

            if (missionStatsSaved != null)
                predicates.add(cb.equal(root.get("missionStatsSaved"), missionStatsSaved));

            return cb.and(predicates.toArray(new Predicate[0]));
        });

    }
}
