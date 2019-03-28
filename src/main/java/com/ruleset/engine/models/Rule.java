package com.ruleset.engine.models;

import com.fasterxml.jackson.databind.JsonNode;
import com.ruleset.engine.criteria.Criterion;
import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Getter
public class Rule {
    private final List<Criterion> criteria;
    private final Map<String, Criterion> criterionMap;

    private final String response;

    public Rule(@NonNull final List<Criterion> criteria, @NonNull final String response) {
        this.criteria = criteria;
        this.response = response;
        this.criterionMap = new HashMap<>();
        initializeCriterionMap(criteria);
    }

    private void initializeCriterionMap(final List<Criterion> criteria) {
        criteria.forEach(criterion -> criterionMap.put(criterion.getField(), criterion));
    }

    /**
     * Accepts the state and determines whether not it matches the Criteria of this Rule.
     * TODO: Return a result object that captures number of pass / fails instead of all
     *  or nothing mattch boolean
     * @param state The state of the world
     * @return boolean
     */
    public boolean isMatch(final Map<String, Comparable> state) {
        boolean passes = true;

        final Iterator<Map.Entry<String, Criterion>> iterator = criterionMap.entrySet().iterator();
        while (iterator.hasNext() && passes) {
            Map.Entry<String, Criterion> entry = iterator.next();
            if (!state.containsKey(entry.getKey())) {
                passes = false;
            } else {
                final Criterion criterion = entry.getValue();
                passes = criterion.compare(state.get(entry.getKey()));
            }
        }

        return passes;
    }
}
