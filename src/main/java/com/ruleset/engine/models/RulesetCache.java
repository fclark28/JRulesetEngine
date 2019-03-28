package com.ruleset.engine.models;

import lombok.Getter;

import java.util.List;

@Getter
public class RulesetCache {

    private final List<Rule> rules;

    public RulesetCache(final List<Rule> rules) {
        this.rules = rules;
    }

}
