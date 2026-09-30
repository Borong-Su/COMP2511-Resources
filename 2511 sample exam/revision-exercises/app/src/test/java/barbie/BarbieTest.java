package barbie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import unsw.barbie.App;

public class BarbieTest {
    @Test
    public void testBarbie() {
        String expected = "Hi! I'm Barbie!\n" + "Hi! I'm Barbie!\n" + "Hi! I'm Barbie!\n" + "I come with me!\n"
                + "And a car!\n" + "As well as a dreamhouse!!!\n" + "I come with me!\n" + "As well as a dreamhouse!!!\n"
                + "I come with me!\n" + "And a car!\n" + "As well as a dreamhouse!!!\n"
                + "The total price of all the barbies is $205\n";

        App app = new App();
        assertEquals(expected, app.output());
    }
}
