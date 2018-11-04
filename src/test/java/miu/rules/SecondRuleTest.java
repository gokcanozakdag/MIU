package miu.rules;

import api.Rule;
import org.junit.Test;

import static miu.rules.RuleTestUtils.assertRuleGenerates;

public class SecondRuleTest {
    private static Rule RULE = new SecondRule();

    @Test
    public void shouldDouble() {
        assertRuleGenerates(RULE, "II", "IIII");
    }
}