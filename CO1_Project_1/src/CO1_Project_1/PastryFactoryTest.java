package CO1_Project_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PastryFactoryTest {

    @Test
    public void testCroissantCreation() {
        PastryFactory factory = new CroissantFactory();
        Pastry pastry = factory.createPastry();
        assertEquals("Croissant", pastry.getName());
    }

    @Test
    public void testMuffinCreation() {
        PastryFactory factory = new MuffinFactory();
        Pastry pastry = factory.createPastry();
        assertEquals("Muffin", pastry.getName());
    }
}
