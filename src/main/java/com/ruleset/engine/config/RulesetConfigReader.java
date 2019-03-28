package com.ruleset.engine.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class RulesetConfigReader {

    private ObjectMapper objectMapper;

    public RulesetConfigReader(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public RulesetConfig generateRuleset(final String jsonString) {
        try {
            return objectMapper.readValue(jsonString, RulesetConfig.class);
        } catch (IOException e) {
            System.out.println(e);
            // @TODO Log that an error occurred
            // @TODO Return an optional
            return null;
        }
    }
}