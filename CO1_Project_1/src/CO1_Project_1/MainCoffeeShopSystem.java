package CO1_Project_1;

import java.util.Scanner;

public class MainCoffeeShopSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Coffee Shop!");
        System.out.println("Choose a coffee:");
        System.out.println("1. Espresso");
        System.out.println("2. Latte");
        System.out.println("3. Cappuccino");

        int coffeeChoice = scanner.nextInt();
        CoffeeFactory coffeeFactory = null;

        switch (coffeeChoice) {
            case 1:
                coffeeFactory = new EspressoFactory();
                break;
            case 2:
                coffeeFactory = new LatteFactory();
                break;
            case 3:
                coffeeFactory = new CappuccinoFactory();
                break;
            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        Coffee coffee = coffeeFactory.createCoffee();
        System.out.println("You ordered: " + coffee);

        // Pastry selection
        System.out.println("Would you like a pastry?");
        System.out.println("1. Croissant");
        System.out.println("2. Muffin");

        int pastryChoice = scanner.nextInt();
        PastryFactory pastryFactory = null;

        
        switch (pastryChoice) {
            case 1:
                pastryFactory = new CroissantFactory();
                break;
            case 2:
                pastryFactory = new MuffinFactory();
                break;
            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        Pastry pastry = pastryFactory.createPastry();
        System.out.println("You also ordered: " + pastry);

        scanner.close();
    }
}
