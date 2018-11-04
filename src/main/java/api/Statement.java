package api;

import java.util.List;
import java.util.stream.Collectors;

public class Statement {
    private final String statement;

    private Statement(String statement) {
        this.statement = statement;
    }

    public static Statement of(String statement) {
        return new Statement(statement);
    }

    public static Statement of(List<Character> characters) {
        return new Statement(characters.stream().map(String::valueOf).collect(Collectors.joining()));
    }

    public List<Character> asSymbolList() {
        return statement.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return statement;
    }

    @Override
    public int hashCode() {
        return this.statement.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Statement) {
            return this == o || o.toString().equals(this.toString());
        }
        return false;
    }
}
