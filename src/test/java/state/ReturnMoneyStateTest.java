package state;

import org.junit.jupiter.api.Test;
import vending.VendingMachine;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReturnMoneyStateTest extends BaseStateTest {
    @Test
    public void canReturnMoney() {
        ReturnMoneyState state = new ReturnMoneyState(100);
        state.returnMoney(new VendingMachine());
        assertEquals("Returned 100 cents", out.toString().trim());
    }
}
