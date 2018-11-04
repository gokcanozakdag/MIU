package miu.rules;

import api.Rule;
import api.Statement;

import java.util.HashSet;
import java.util.Set;

public class SecondRule implements Rule {
    public static Rule INSTANCE = new SecondRule();

    @Override
    public Set<Statement> apply(Statement statement) {
        Set<Statement> result = new HashSet<>();
        result.add(Statement.of(statement.toString() + statement.toString()));
        return result;
    }
}
