package api;

import java.util.Set;

public interface Rule {
    Set<Statement> apply(Statement theorem);
}
