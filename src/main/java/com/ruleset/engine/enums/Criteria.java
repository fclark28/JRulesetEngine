package com.ruleset.engine.enums;

public enum Criteria {
  EQUALS("equals"),
  EXISTS("exists"),
  CONTAINS("contains");

  private String criteria;

  Criteria(final String criteria) {
    this.criteria = criteria;
  }

  public String getValue() {
    return criteria;
  }
}