package com.ruleset.engine.enums;

public enum ComparisonType {
  EQUALS("equals"),
  EXISTS("exists"),
  CONTAINS("contains"),
  GREATER_THAN("greaterThan"),
  LESS_THAN("lessThan");

  private String criteria;

  ComparisonType(final String criteria) {
    this.criteria = criteria;
  }

  public String getValue() {
    return criteria;
  }
}