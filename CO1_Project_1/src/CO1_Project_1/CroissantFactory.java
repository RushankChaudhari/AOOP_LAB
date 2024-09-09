package CO1_Project_1;

public class CroissantFactory extends PastryFactory {
    @Override
    public Pastry createPastry() {
        return new Croissant();
    }
}
