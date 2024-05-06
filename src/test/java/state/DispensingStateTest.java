package state;

import org.junit.jupiter.api.Test;
import snack.Snack;
import vending.VendingMachine;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DispensingStateTest extends BaseStateTest {
    @Test
    public void canDispenseSnack() {
        VendingMachine machine = new VendingMachine();
        Snack snack = new Snack("Snack", 100, 1);
        machine.addSnack(snack);
        DispensingState state = new DispensingState(snack, 0);
        state.dispenseSnack(machine);
        assertEquals("Dispensing Snack", out.toString().trim());
    }
}
