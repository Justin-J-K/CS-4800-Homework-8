package state;

import snack.Snack;
import vending.VendingMachine;

public class WaitingForMoneyState extends StateOfVendingMachine {
    private final Snack snack;
    private final int moneyInCentsRequired;
    private int moneyInCentsInserted = 0;

    public WaitingForMoneyState(Snack snack) {
        this.snack = snack;
        this.moneyInCentsRequired = snack.getPriceInCents();
    }

    @Override
    public void selectSnack(VendingMachine vendingMachine, String snackName) {
        // do nothing
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, int moneyInCents) {
        moneyInCentsInserted += moneyInCents;
        System.out.println("Inserted " + moneyInCents + " cents");
        if (hasInsertedEnoughMoney()) {
            int change = moneyInCentsInserted - moneyInCentsRequired;
            vendingMachine.setState(new DispensingState(snack, change));
        }
    }

    private boolean hasInsertedEnoughMoney() {
        return moneyInCentsInserted >= moneyInCentsRequired;
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
