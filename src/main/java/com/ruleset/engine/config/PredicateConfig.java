package com.ruleset.engine.config;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PredicateConfig {
  private String attribue;
  private String value;
  private String criteria;
}