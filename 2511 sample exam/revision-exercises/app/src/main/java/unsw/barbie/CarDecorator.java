package unsw.barbie;

public class CarDecorator extends Decorator{
    public CarDecorator(Barbie barbie) {
        super(barbie);
    }

    @Override
    public String accessories() {
        return super.accessories() + "And a car!\n";
    }

    @Override
    public int price() {
        return super.price() + 20;
    }
}
