package com.ruleset.engine.models;

public interface Predicate {

    public boolean evaluate(final String key, final String value);
}
