package unsw.shopping;

public class SupermarketFactory {
    public static Supermarket create(String name) {

        if (name.equals("Coles")) {
            return new Coles();

        } else if (name.equals("Woolies")) {
            return new Woolworths();
        }

        return null;
    }
}