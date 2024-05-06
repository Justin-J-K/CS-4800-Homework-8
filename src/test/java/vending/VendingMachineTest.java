package vending;

import handler.SnackDispenseHandler;
import org.junit.jupiter.api.Test;
import snack.Snack;
import state.ReturnMoneyState;
import state.StateOfVendingMachine;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {
    @Test
    public void canAddAndGetSnackFromVendingMachine() {
        VendingMachine machine = new VendingMachine();
        Snack snack = new Snack("Snack", 100, 1);
        machine.addSnack(snack);
        assertEquals(snack, machine.getSnack("Snack"));
    }

    @Test
    public void canGetHandler() throws NoSuchFieldException, IllegalAccessException {
        VendingMachine machine = new VendingMachine();
        Snack snack = new Snack("Snack", 100, 1);
        machine.addSnack(snack);

        Field handlerField = machine.getClass().getDeclaredField("handler");
        handlerField.setAccessible(true);
        SnackDispenseHandler handler = (SnackDispenseHandler) handlerField.get(machine);

        Field snackField = handler.getClass().getDeclaredField("snack");
        snackField.setAccessible(true);
        Snack snackInField = (Snack) snackField.get(handler);

        assertSame(snack, snackInField);
    }

    @Test
    public void canSetState() throws NoSuchFieldException, IllegalAccessException {
        VendingMachine machine = new VendingMachine();
        ReturnMoneyState state = new ReturnMoneyState(10);
        machine.setState(state);

        Field stateField = machine.getClass().getDeclaredField("state");
        stateField.setAccessible(true);
        ReturnMoneyState stateInField = (ReturnMoneyState) stateField.get(machine);

        assertSame(state, stateInField);
    }

    @Test
    public void selectSnackCallsState() {
        VendingMachine machine = new VendingMachine();
        boolean[] didCall = checkVendingMachineCallsState(machine);
        machine.selectSnack("Snack");
        assertTrue(didCall[0]);
    }

    @Test
    public void insertMoneyCallsState() {
        VendingMachine machine = new VendingMachine();
        boolean[] didCall = checkVendingMachineCallsState(machine);
        machine.insertMoney(0);
        assertTrue(didCall[1]);
    }

    @Test
    public void dispenseSnackCallsState() {
        VendingMachine machine = new VendingMachine();
        boolean[] didCall = checkVendingMachineCallsState(machine);
        machine.dispenseSnack();
        assertTrue(didCall[2]);
    }

    @Test
    public void returnMoneyCallsState() {
        VendingMachine machine = new VendingMachine();
        boolean[] didCall = checkVendingMachineCallsState(machine);
        machine.returnMoney();
        assertTrue(didCall[3]);
    }

    private boolean[] checkVendingMachineCallsState(VendingMachine machine) {
        final boolean[] didCall = {false, false, false, false};
        machine.setState(new StateOfVendingMachine() {
            @Override
            public void selectSnack(VendingMachine vendingMachine, String snackName) {
                didCall[0] = true;
            }

            @Override
            public void insertMoney(VendingMachine vendingMachine, int moneyInCents) {
                didCall[1] = true;
            }

            @Override
            public void dispenseSnack(VendingMachine vendingMachine) {
                didCall[2] = true;
            }

            @Override
            public void returnMoney(VendingMachine vendingMachine) {
                didCall[3] = true;
            }
        });
        return didCall;
    }
}
