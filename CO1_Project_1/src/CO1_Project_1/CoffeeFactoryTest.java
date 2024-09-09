package CO1_Project_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoffeeFactoryTest {

    @Test
    public void testEspressoCreation() {
        CoffeeFactory factory = new EspressoFactory();
        Coffee coffee = factory.createCoffee();
        assertEquals("Espresso", coffee.getName());
        assertEquals("Coffee beans, Water", coffee.getIngredients());
    }

    @Test
    public void testLatteCreation() {
        CoffeeFactory factory = new LatteFactory();
        Coffee coffee = factory.createCoffee();
        assertEquals("Latte", coffee.getName());
        assertEquals("Coffee beans, Water, Milk", coffee.getIngredients());
    }

    @Test
    public void testCappuccinoCreation() {
        CoffeeFactory factory = new CappuccinoFactory();
        Coffee coffee = factory.createCoffee();
        assertEquals("Cappuccino", coffee.getName());
        assertEquals("Coffee beans, Water, Milk, Milk foam", coffee.getIngredients());
    }
}
