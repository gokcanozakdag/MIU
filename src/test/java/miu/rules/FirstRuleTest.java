package miu.rules;

import api.Rule;
import org.junit.Test;

import static miu.rules.RuleTestUtils.assertRuleGenerates;

public class FirstRuleTest {
    private static Rule RULE = new FirstRule();

    @Test
    public void shouldAddUAfterI() {
        assertRuleGenerates(RULE, "MI", "MIU", "MIU");
    }
}