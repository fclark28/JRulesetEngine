package com.ruleset.engine.criteria;

import com.ruleset.engine.enums.ComparisonType;

public interface Criterion<T extends Comparable<T>> {

    boolean compare(final T value);

    ComparisonType getType();

    String getField();
}
