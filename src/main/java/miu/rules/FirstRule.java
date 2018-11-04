package miu.rules;

import api.Rule;
import api.Statement;

import java.util.HashSet;
import java.util.Set;

public class FirstRule implements Rule {
    public static Rule INSTANCE = new FirstRule();

    @Override
    public Set<Statement> apply(Statement statement) {
        Set<Statement> result = new HashSet<>();
        String statementString = statement.toString();
        if (statementString.endsWith("I")) {
            result.add(Statement.of(statementString + "U"));
        }
        return result;
    }
}
