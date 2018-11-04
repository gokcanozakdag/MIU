package miu.rules;

import api.Rule;
import org.junit.Test;

import static miu.rules.RuleTestUtils.assertRuleGenerates;

public class ThirdRuleTest {
    private static Rule RULE = new ThirdRule();

    @Test
    public void shouldConvertIIIToU() {
        assertRuleGenerates(RULE, "MIIII", "MUI", "MIU");
    }

}