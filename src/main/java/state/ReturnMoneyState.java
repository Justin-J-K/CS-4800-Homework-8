package state;

import vending.VendingMachine;

public class ReturnMoneyState extends StateOfVendingMachine {
    private final int moneyToReturn;

    public ReturnMoneyState(int moneyToReturn) {
        this.moneyToReturn = moneyToReturn;
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
        // do nothing
    }

    @Override
    public void returnMoney(VendingMachine vendingMachine) {
        System.out.println("Returned " + moneyToReturn + " cents");
        vendingMachine.setState(new IdleState());
    }
}
