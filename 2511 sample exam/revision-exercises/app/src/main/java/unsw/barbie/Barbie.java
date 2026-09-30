package unsw.barbie;

public class Barbie implements Doll {
    @Override
    public String sayHello() {
        return "Hi! I'm Barbie!";
    }

    public String accessories() {
        return "I come with me!\n";
    }

    public int price() {
        return 25;
    }
}
