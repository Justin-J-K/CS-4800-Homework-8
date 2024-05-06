package state;

import org.junit.jupiter.api.Test;
import snack.Snack;
import vending.VendingMachine;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaitingForMoneyStateTest extends BaseStateTest {
    @Test
    public void canInsertMoney() {
        Snack snack = new Snack("Snack", 100, 1);
        WaitingForMoneyState state = new WaitingForMoneyState(snack);
        state.insertMoney(new VendingMachine(), 50);
        assertEquals("Inserted 50 cents", out.toString().trim());
    }
}
