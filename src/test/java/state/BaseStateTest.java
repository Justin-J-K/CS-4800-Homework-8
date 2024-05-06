package state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class BaseStateTest {
    protected ByteArrayOutputStream out;
    private final PrintStream standardOut = System.out;

    @BeforeEach
    public void setup() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    public void teardown() {
        System.setOut(standardOut);
    }

    @Test
    public void canSelectSnack() {
        // pass test by default
    }

    @Test
    public void canInsertMoney() {
        // pass test by default
    }

    @Test
    public void canDispenseSnack() {
        // pass test by default
    }

    @Test
    public void canReturnMoney() {
        // pass test by default
    }
}
