package unsw.shopping;

import java.util.List;

public class Woolworths extends Supermarket {
    public Woolworths() {
        super("Everyday Rewards", 55);
    }

    public void printItemOverMaximum() {
        System.out.println("Sorry, that's more than we can handle in a single order!");
    }

    public void printReceipt(List<Item> items ) {
        System.out.print("Your purchase: ");

        for (int i = 0; i < items.size() - 1; i++) {
            System.out.print(items.get(i).getName() + ", ($" + items.get(i).getPrice() + "), ");
        }

        System.out.println(
            items.get(items.size() - 1).getName() + " ($" + items.get(items.size() - 1).getPrice() + ").");
    }
}
