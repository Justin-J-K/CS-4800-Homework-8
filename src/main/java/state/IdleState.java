package state;

import snack.Snack;
import vending.VendingMachine;

public class IdleState extends StateOfVendingMachine {
    @Override
    public void selectSnack(VendingMachine vendingMachine, String snackName) {
        Snack snack = vendingMachine.getSnack(snackName);
        if (snack != null) {
            System.out.println("Selected " + snackName);
            vendingMachine.setState(new WaitingForMoneyState(snack));
        } else {
            System.out.println("There is no snack called " + snackName);
        }
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, int moneyInCents) {
        // do nothing
    }

    @Override
    public void dispenseSnack(VendingMachine vendingMachine) {
        // do nothing
    }

    @Override
    public void returnMoney(VendingMachine vendingMachine) {
        // do nothing
    }
}
