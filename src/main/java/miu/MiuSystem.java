package miu;

import api.FormalSystem;
import api.Statement;
import com.google.common.collect.ImmutableSet;
import miu.rules.FirstRule;
import miu.rules.SecondRule;
import miu.rules.ForthRule;
import miu.rules.ThirdRule;

import java.util.Set;

public class MiuSystem {
    private static Set<Character> symbols = ImmutableSet.of('M', 'I', 'U');
    private final FormalSystem formalSystem = FormalSystem.of(symbols, ImmutableSet.of(
            FirstRule.INSTANCE,
            ForthRule.INSTANCE,
            ThirdRule.INSTANCE,
            SecondRule.INSTANCE
    ));

    public MiuSystem() {
        formalSystem.addAxiom(Statement.of("I"));
    }

    public boolean isTheorem(Statement statement) {
        return this.formalSystem.isTheorem(statement);
    }
}
