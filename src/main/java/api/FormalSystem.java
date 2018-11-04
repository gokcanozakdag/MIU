package api;

import java.util.*;
import java.util.stream.Collectors;

public class FormalSystem {
    private static final int MAX_ITERATION = 100_000;
    private Set<Statement> axioms = new HashSet<>();

    private Set<Character> symbols;
    private Set<Rule> rules;

    private FormalSystem(Set<Character> symbols, Set<Rule> rules) {
        this.symbols = symbols;
        this.rules = rules;
    }

    public static FormalSystem of(Set<Character> symbols, Set<Rule> rules) {
        return new FormalSystem(symbols, rules);
    }

    public void addAxiom(Statement statement) {
        checkStatement(statement);
        axioms.add(statement);
    }

    public boolean isTheorem(Statement statement) {
        Queue<Statement> boundaryTheorems = new LinkedList<>(axioms);
        int iterations = 0;

        while (iterations < MAX_ITERATION && !boundaryTheorems.isEmpty()) {
            Statement theorem = boundaryTheorems.poll();

            if (theorem.equals(statement)) {
                return true;
            }

            Set<Statement> newTheorems = applyRules(theorem);
            newTheorems.forEach(boundaryTheorems::offer);
            iterations++;
        }

        return false;
    }

    private Set<Statement> applyRules(Statement statement) {
        return rules.stream()
                .map(r -> r.apply(statement))
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    private void checkStatement(Statement statement) {
        for (Character symbol:statement.asSymbolList()) {
            if (!symbols.contains(symbol)) {
                throw new IllegalArgumentException("not a valid statement");
            }
        }
    }
}
