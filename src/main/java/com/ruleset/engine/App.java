package com.ruleset.engine;

import com.ruleset.engine.criteria.Criterion;
import com.ruleset.engine.criteria.EqualsCriterion;
import com.ruleset.engine.models.Rule;
import com.ruleset.engine.models.RulesetCache;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EqualsCriterion<Integer> equalsFive = new EqualsCriterion<>("number", 5);
        EqualsCriterion<Integer> equalsTen = new EqualsCriterion<>("number", 10);

        List<Criterion> firstCriterion = Collections.singletonList(equalsFive);
        List<Criterion> secondCriterion = Collections.singletonList(equalsTen);

        String fiveNodeResponse = "You found the five!";
        String tenNodeResponse = "You found the ten!";

        Rule firstRule = new Rule(firstCriterion, fiveNodeResponse);
        Rule secondRule = new Rule(secondCriterion, tenNodeResponse);

        List<Rule> ruleList = Arrays.asList(firstRule, secondRule);

        RulesetCache rulesetCache = new RulesetCache(ruleList);

        RulesetExecutor executor = new RulesetExecutor(rulesetCache);


        Map<String, Comparable> state = new HashMap<>();
        state.put("number", 5);

        Optional<Rule> r = executor.findMatchingRule(state);
        if (!r.isPresent()) {
            System.out.println("No rule returned");
            return;
        }

        System.out.println(r.get().getResponse());
    }
}
