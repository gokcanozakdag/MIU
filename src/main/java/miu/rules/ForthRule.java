package miu.rules;

import api.Rule;
import api.Statement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ForthRule implements Rule {
    public static Rule INSTANCE = new ForthRule();

    @Override
    public Set<Statement> apply(Statement statement) {
        Set<Statement> result = new HashSet<>();
        List<Character> characters = statement.asSymbolList();
        for (int i = 0; i < characters.size() - 1; i++) {
            if (characters.get(i) == 'U' && characters.get(i + 1) == 'U') {
                List<Character> temp = new ArrayList<>(characters.subList(0, i));
                temp.addAll(new ArrayList<>(characters.subList(i + 2, characters.size())));
                result.add(Statement.of(temp));
            }
        }
        return result;
    }
}
