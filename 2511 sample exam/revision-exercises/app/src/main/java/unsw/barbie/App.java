package unsw.barbie;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Create some barbie dolls
        Barbie barbie1 = new Barbie();
        barbie1 = new CarDecorator(barbie1);
        barbie1 = new DreamhouseDecorator(barbie1);

        Barbie barbie2 = new Barbie();
        barbie2 = new DreamhouseDecorator(barbie2);

        Barbie barbie3 = new Barbie();
        barbie3 = new CarDecorator(barbie3);

        // Create some Ken dolls
        Ken ken1 = new Ken();
        Ken ken2 = new Ken();
        Ken ken3 = new Ken();

        // Create a box to store our barbies
        BarbieBox barbieBox = new BarbieBox();

        // Later, we decide to give Barbie 3 a dreamhouse as well
        barbie3 = new DreamhouseDecorator(barbie3);

        barbieBox.putBarbieInBox(barbie1);
        barbieBox.putBarbieInBox(barbie2);
        barbieBox.putBarbieInBox(barbie3);

        List<Barbie> allBarbies = barbieBox.getBarbies();

        allBarbies.forEach(b -> System.out.println(b.sayHello()));

        allBarbies.forEach(b -> System.out.print(b.accessories()));

        System.out.println("The total price of all the barbies is $"
                + allBarbies.stream().map(Barbie::price).reduce(0, Integer::sum));
    }

    public String output() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setOut(new PrintStream(out));
        App.main(new String[] {});
        System.setOut(System.out);

        return out.toString();
    }
}
