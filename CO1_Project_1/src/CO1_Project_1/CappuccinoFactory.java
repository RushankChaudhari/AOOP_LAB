package CO1_Project_1;

public class CappuccinoFactory extends CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new Cappuccino();
    }
}
