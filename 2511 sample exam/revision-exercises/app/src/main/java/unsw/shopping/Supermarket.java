package unsw.shopping;

import java.util.List;

public abstract class Supermarket {
    private String cardName;
    private int MaximumItems;

    public Supermarket(String cardName, int MaximumItems) {
        this.cardName = cardName;
        this.MaximumItems = MaximumItems;
    }

    public void printWelcome() {
        System.out.println("Welcome! Please scan your first item. If you have a " + cardName
                + " card, please scan it at any time.");
    }

    public abstract void printItemOverMaximum();

    public int getMaximumItems() {
        return this.MaximumItems;
    }

    public abstract void printReceipt(List<Item> items);
}
