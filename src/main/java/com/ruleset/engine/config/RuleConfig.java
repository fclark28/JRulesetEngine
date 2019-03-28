package com.ruleset.engine.config;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RuleConfig {
  private List<PredicateConfig> predicateConfigs;
  private JsonNode response;
}