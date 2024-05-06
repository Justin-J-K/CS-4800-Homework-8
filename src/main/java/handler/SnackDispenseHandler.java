package handler;

import snack.Snack;

public class SnackDispenseHandler {
    private SnackDispenseHandler next;
    private Snack snack;

    public SnackDispenseHandler(SnackDispenseHandler next, Snack snack) {
        this.next = next;
        this.snack = snack;
    }

    public void dispenseSnack(String snackName) {
        if (snack.getName().equals(snackName)) {
            if (snack.isOutOfStock()) throw new OutOfStockException(snackName);

            System.out.println("Dispensing " + snackName);
            snack.decrementQuantity();
        } else if (next != null) {
            System.out.println("Handling passed from " + snack.getName());
            next.dispenseSnack(snackName);
        }
    }
}
