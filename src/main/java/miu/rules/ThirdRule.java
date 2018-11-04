package miu.rules;

import api.Rule;
import api.Statement;

import java.util.*;

public class ThirdRule implements Rule {
    public static Rule INSTANCE = new ThirdRule();

    @Override
    public Set<Statement> apply(Statement statement) {
        Set<Statement> result = new HashSet<>();
        List<Character> characters = statement.asSymbolList();
        for (int i = 0; i < characters.size() - 2; i++) {
            if (characters.subList(i, i+3).stream().allMatch(c -> c == 'I')) {
                List<Character> temp = new ArrayList<>(characters.subList(0, i));
                temp.add('U');
                temp.addAll(characters.subList(i+3, characters.size()));
                result.add(Statement.of(temp));
            }
        }
        return result;
    }
}
