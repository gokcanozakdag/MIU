package miu.rules;

import api.Rule;
import org.junit.Test;

import static miu.rules.RuleTestUtils.assertRuleGenerates;

public class ForthRuleTest {
    private static Rule RULE = new ForthRule();

    @Test
    public void shouldRemoveDoubleU() {
        assertRuleGenerates(RULE, "MUUIUU", "MIUU", "MUUI");
    }
}