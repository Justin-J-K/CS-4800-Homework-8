package state;

import handler.OutOfStockException;
import handler.SnackDispenseHandler;
import snack.Snack;
import vending.VendingMachine;

public class DispensingState extends StateOfVendingMachine {
    private final Snack snack;
    private final int changeInCents;

    public DispensingState(Snack snack, int changeInCents) {
        this.snack = snack;
        this.changeInCents = changeInCents;
    }

    @Override
    public void selectSnack(VendingMachine vendingMachine, String snackName) {
        // do nothing
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, int moneyInCents) {
        // do nothing
    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        try {
            SnackDispenseHandler handler = vendingMachine.getHandler();
            handler.dispenseSnack(snack.getName());
            vendingMachine.setState(new ReturnMoneyState(changeInCents));
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());

            int moneyInserted = snack.getPriceInCents() + changeInCents;
            vendingMachine.setState(new ReturnMoneyState(moneyInserted));
        }
    }

    @Override
    public void returnMoney(VendingMachine vendingMachine) {
        // do nothing
    }
}
