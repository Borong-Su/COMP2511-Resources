package unsw.shopping;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CheckoutSystem {
    private int amountPurchased;

    private Supermarket supermarket;

    private CheckoutSystem(String supermarket) {
        this.supermarket = SupermarketFactory.create(supermarket);
    }

    public static CheckoutSystem instance(String supermarket) {
        return new CheckoutSystem(supermarket);
    }

    public void checkout(List<Item> items, String paymentMethod, int paymentAmount, boolean receipt) {
        // Welcome the user
        supermarket.printWelcome();

        // Scan the items
        scanItems(items);

        // Take the user's payment
        if (paymentAmount < amountPurchased) {
            System.out.println("Not enough $$$.");
            return;
        }

        if (paymentMethod.equals("cash")) {
            System.out.println("Paid $" + paymentAmount + " with $" + (paymentAmount - amountPurchased) + " change.");
        } else {
            paymentAmount = amountPurchased;
            System.out.println("Paid $" + paymentAmount + ".");
        }

        // Print the receipt
        if (receipt) {
            supermarket.printReceipt(items);
        }
    }

    public void scanItems(List<Item> items) {
        // Supermarkets have restrictions on the number of items allowed
        if (items.size() > supermarket.getMaximumItems()) {
            supermarket.printItemOverMaximum();
        }

        if (items.size() == 0) {
            System.out.println("You do not have any items to purchase.");
            return;
        }

        for (Item item : items) {
            amountPurchased += item.getPrice();
        }
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<Item>(
                Arrays.asList(new Item("Apple", 1), new Item("Orange", 1), new Item("Avocado", 5)));

        CheckoutSystem checkout = new CheckoutSystem("Woolies");
        checkout.checkout(items, "cash", 200, true);
    }
}
