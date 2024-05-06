import snack.Snack;
import vending.VendingMachine;

public class VendingMachineDriver {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        machine.addSnack(new Snack("Snickers", 100, 0));
        machine.addSnack(new Snack("KitKat", 200, 1));
        machine.addSnack(new Snack("Doritos", 500, 1));
        machine.addSnack(new Snack("Cheetos", 350, 4));
        machine.addSnack(new Snack("Pepsi", 50, 2));
        machine.addSnack(new Snack("Coke", 500, 2));

        System.out.println("Trying to buy Snickers:");

        machine.selectSnack("Snickers");
        machine.insertMoney(120);
        machine.dispenseSnack();
        machine.returnMoney();

        System.out.println("\nTrying to buy KitKat:");

        machine.selectSnack("KitKat");
        machine.insertMoney(150);
        machine.insertMoney(50);
        machine.insertMoney(20);
        machine.dispenseSnack();
        machine.returnMoney();

        System.out.println("\nTrying to buy KitKat again:");

        machine.selectSnack("KitKat");
        machine.insertMoney(200);
        machine.dispenseSnack();
        machine.returnMoney();

        System.out.println("\nTrying to buy Doritos:");

        machine.selectSnack("Doritos");
        machine.insertMoney(500);
        machine.dispenseSnack();
        machine.returnMoney();

        System.out.println("\nTrying to buy Coke:");

        machine.selectSnack("Coke");
        machine.insertMoney(1000);
        machine.dispenseSnack();
        machine.returnMoney();
    }
}
