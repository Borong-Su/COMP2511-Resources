package unsw.shopping;

import java.util.List;

public class Coles extends Supermarket {
    public Coles() {
        super("flybuys", 20);
    }

    public void printItemOverMaximum() {
        System.out.println("Too many items.");
    }

    public void printReceipt(List<Item> items) {
        System.out.println("Today at Coles you purchased the following:");

        for (Item item : items) {
            System.out.println("- " + item.getName() + " : $" + item.getPrice());
        }
    }
}
