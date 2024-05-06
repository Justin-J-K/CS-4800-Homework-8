package snack;

public class Snack {
    private String name;
    private int priceInCents;
    private int quantity;

    public Snack(String name, int priceInCents, int quantity) {
        this.name = name;
        this.priceInCents = Math.max(0, priceInCents);
        this.quantity = Math.max(0, quantity);
    }

    public String getName() {
        return name;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public void decrementQuantity() {
        if (quantity <= 0) return;
        quantity--;
    }

    public boolean isOutOfStock() {
        return quantity <= 0;
    }
}
