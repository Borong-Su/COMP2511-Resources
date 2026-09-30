package unsw.barbie;

public class DreamhouseDecorator extends Decorator{
    public DreamhouseDecorator(Barbie barbie) {
        super(barbie);
    }

    @Override
    public String accessories() {
        return super.accessories() + "As well as a dreamhouse!!!\n";
    }

    @Override
    public int price() {
        return super.price() + 30;
    }
}
