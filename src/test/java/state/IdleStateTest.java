package state;

import org.junit.jupiter.api.Test;
import snack.Snack;
import vending.VendingMachine;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdleStateTest extends BaseStateTest {
    @Test
    public void canSelectSnack() {
        VendingMachine machine = new VendingMachine();
        Snack snack = new Snack("Snack", 100, 1);
        machine.addSnack(snack);
        IdleState state = new IdleState();
        state.selectSnack(machine, "Snack");
        assertEquals("Selected Snack", out.toString().trim());
    }
}
