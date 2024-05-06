package state;

import vending.VendingMachine;

public abstract class StateOfVendingMachine {
    public abstract void selectSnack(VendingMachine vendingMachine, String snackName);
    public abstract void insertMoney(VendingMachine vendingMachine, int moneyInCents);
    public abstract void dispenseSnack(VendingMachine vendingMachine);
    public abstract void returnMoney(VendingMachine vendingMachine);
}
