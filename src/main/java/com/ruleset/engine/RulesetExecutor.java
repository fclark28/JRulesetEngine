package com.ruleset.engine;

import com.ruleset.engine.models.Rule;
import com.ruleset.engine.models.RulesetCache;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RulesetExecutor {

    private final RulesetCache rulesetCache;

    public RulesetExecutor(final RulesetCache rulesetCache) {
        this.rulesetCache = rulesetCache;
    }

    public Optional<Rule> findMatchingRule(final Map<String, Comparable> state) {
        final List<Rule> rules = rulesetCache.getRules();

        int i = 0;
        Optional<Rule> matchingRule = Optional.empty();
        for (; i < rules.size(); i++) {
            if (rules.get(i).isMatch(state)) {
                matchingRule = Optional.of(rules.get(i));
            }
        }

        return matchingRule;
    }
}
