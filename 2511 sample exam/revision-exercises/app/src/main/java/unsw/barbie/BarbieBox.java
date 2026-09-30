package unsw.barbie;

import java.util.ArrayList;
import java.util.List;

public class BarbieBox {
    private List<Barbie> barbies = new ArrayList<>();

    public void putBarbieInBox(Barbie barbie) {
        barbies.add(barbie);
    }

    public List<Barbie> getBarbies() {
        return barbies;
    }
}