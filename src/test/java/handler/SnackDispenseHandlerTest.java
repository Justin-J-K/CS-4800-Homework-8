package handler;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import snack.Snack;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnackDispenseHandlerTest {
    private ByteArrayOutputStream out;
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
    public void handlerDispensesSnack() {
        SnackDispenseHandler handler = new SnackDispenseHandler(null, new Snack("Name", 0, 1));
        handler.dispenseSnack("Name");
        assertEquals("Dispensing Name", out.toString().trim());
    }

    @Test
    public void handlerPassesToNextHandler() {
        SnackDispenseHandler handler1 = new SnackDispenseHandler(null, new Snack("Name", 0, 1));
        SnackDispenseHandler handler2 = new SnackDispenseHandler(handler1, new Snack("Name2", 0, 1));
        handler2.dispenseSnack("Name");
        assertEquals("Handling passed from Name2\n" +
                "Dispensing Name", out.toString().trim());
    }
}
