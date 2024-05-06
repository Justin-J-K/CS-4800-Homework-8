package handler;

public class OutOfStockException extends IllegalStateException {
    public OutOfStockException(String snackName) {
        super(snackName + " is out of stock");
    }
}
