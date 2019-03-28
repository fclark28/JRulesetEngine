package com.ruleset.engine.criteria;

import com.ruleset.engine.enums.ComparisonType;

public class GreaterThanCriterion<T extends Comparable<T>> implements Criterion<T> {

    private final String field;
    private final T criterionValue;

    public GreaterThanCriterion(final String field, final T criterionValue) {
        this.field = field;
        this.criterionValue = criterionValue;
    }

    @Override
    public boolean compare(T value) {
        return value.compareTo(criterionValue) > 0;
    }

    @Override
    public ComparisonType getType() {
        return ComparisonType.GREATER_THAN;
    }

    @Override
    public String getField() {
        return field;
    }
}
