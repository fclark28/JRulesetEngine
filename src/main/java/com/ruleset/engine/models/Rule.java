package com.ruleset.engine.models;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public class Rule {
    private List<Predicate> predicates;
    private JsonNode response;
}
