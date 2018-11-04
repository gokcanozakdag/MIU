package miu;

import api.Statement;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MiuSystemTest {
    private final MiuSystem miu = new MiuSystem();

    @Test
    public void canGenerateTheorems() {
        assertTheorem("IU");
        assertTheorem("IUIU");
        assertTheorem("IIII", "IIIIU", "IUU", "I");
    }

    @Test
    public void canNotGenerateTheorems() {
        assertNotTheorem("U");
    }

    private void assertTheorem(String... statements) {
        Arrays.stream(statements).forEach(s -> assertTrue(miu.isTheorem(Statement.of(s))));
    }

    private void assertNotTheorem(String... statements) {
        Arrays.stream(statements).forEach(s -> assertFalse(miu.isTheorem(Statement.of(s))));
    }
}