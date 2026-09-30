package unsw.shipping;

public class DiscountDecorator extends Decorator {
    private double discount;

    public DiscountDecorator(Product product, double discount) {
        super(product);

        this.discount = discount;
    }

    @Override
    public double getPrice() {
        return super.getPrice() * (1 - discount * 0.01);
    }

    @Override
    public int getWeight() {
        return super.getWeight();
    }
}
