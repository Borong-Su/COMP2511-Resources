package unsw.barbie;

public abstract class Decorator extends Barbie{
    private Barbie barbie;

    public Decorator(Barbie barbie) {
        this.barbie = barbie;
    }

    @Override
    public String accessories() {
        return barbie.accessories();
    }

    @Override
    public int price() {
        return barbie.price();
    }
}
