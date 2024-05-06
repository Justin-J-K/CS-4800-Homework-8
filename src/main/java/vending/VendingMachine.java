package vending;

import handler.SnackDispenseHandler;
import snack.Snack;
import state.IdleState;
import state.StateOfVendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Snack> snacks;
    private SnackDispenseHandler handler;
    private StateOfVendingMachine state;

    public VendingMachine() {
        this.snacks = new ArrayList<>();
        this.state = new IdleState();
    }

    public void addSnack(Snack snack) {
        snacks.add(snack);
        handler = new SnackDispenseHandler(handler, snack);
    }

    public Snack getSnack(String snackName) {
        for (Snack snack : snacks) {
            if (snack.getName().equals(snackName)) {
                return snack;
            }
        }
        return null;
    }

    public SnackDispenseHandler getHandler() {
        return handler;
    }

    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public void selectSnack(String snackName) {
        state.selectSnack(this, snackName);
    }

    public void insertMoney(int moneyInCents) {
        state.insertMoney(this, moneyInCents);
    }

    public void dispenseSnack() {
        state.dispenseSnack(this);
    }

    public void returnMoney() {
        state.returnMoney(this);
    }
}
