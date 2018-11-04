package miu.rules;

import api.Rule;
import api.Statement;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class RuleTestUtils {
    public static void assertRuleGenerates(Rule rule, String axiom, String... theorems) {
        Set<Statement> generatedTheorems = rule.apply(Statement.of(axiom));
        Set<Statement> expected = Arrays.stream(theorems).map(Statement::of).collect(Collectors.toSet());
        assertTrue(expected.size() == generatedTheorems.size() && expected.containsAll(generatedTheorems));
    }
}
