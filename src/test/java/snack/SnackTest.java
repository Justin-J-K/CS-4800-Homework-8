package snack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SnackTest {
    private Snack snack;

    @BeforeEach
    public void setup() {
        snack = new Snack("Name", 100, 1);
    }

    @Test
    public void canGetNameOfSnack() {
        assertEquals("Name", snack.getName());
    }

    @Test
    public void canGetPriceOfSnack() {
        assertEquals(100, snack.getPriceInCents());
    }

    @Test
    public void canDecrementQuantityOfSnacks() throws NoSuchFieldException, IllegalAccessException {
        snack.decrementQuantity();

        Field field = snack.getClass().getDeclaredField("quantity");
        field.setAccessible(true);
        int quantity = field.getInt(snack);

        assertEquals(0, quantity);
    }

    @Test
    public void canCheckIsOutOfStock() {
        snack.decrementQuantity();
        assertTrue(snack.isOutOfStock());
    }
}
