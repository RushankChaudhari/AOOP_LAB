package CO1_Project_1;

public class MuffinFactory extends PastryFactory {
    @Override
    public Pastry createPastry() {
        return new Muffin();
    }
}
