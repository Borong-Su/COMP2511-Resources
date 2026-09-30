package unsw.shipping;

public class FreeShippingDecorator extends Decorator {
    private double cost;
    private int weigh;

    public FreeShippingDecorator(Product product, double cost, int weigh) {
        super(product);

        this.cost = cost;
        this.weigh = weigh;
    }

    @Override
    public double getShippingCost() {
        if (super.getPrice() > this.cost && super.getWeight() < this.weigh) {
            return 0.0;
        }

        return super.getShippingCost();
    }
}
