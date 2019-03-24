package com.ruleset.engine.config;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RulesetConfig {
  private List<RuleConfig> rules;
}