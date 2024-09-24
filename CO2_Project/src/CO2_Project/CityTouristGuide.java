package CO2_Project;

import java.util.Scanner;
import java.util.*;

public class CityTouristGuide {

    private Map<String, Set<String>> cityGuide;

    public CityTouristGuide() {
        cityGuide = new HashMap<>();
    }

   
    public void addTouristSpot(String category, String spot) {
        
        cityGuide.putIfAbsent(category, new HashSet<>());
        
       
        cityGuide.get(category).add(spot);
        System.out.println(spot + " has been added to the " + category + " category.");
    }

    
    public void removeTouristSpot(String category, String spot) {
        
        if (cityGuide.containsKey(category)) {
            Set<String> spots = cityGuide.get(category);
            if (spots.remove(spot)) {
                System.out.println(spot + " has been removed from the " + category + " category.");
            } else {
                System.out.println(spot + " was not found in the " + category + " category.");
            }
        } else {
            System.out.println("Category " + category + " does not exist.");
        }
    }

    
    public void listSpotsInCategory(String category) {
        
        if (cityGuide.containsKey(category)) {
            Set<String> spots = cityGuide.get(category);
            System.out.println("Tourist spots in the " + category + " category:");
            for (String spot : spots) {
                System.out.println("- " + spot);
            }
        } else {
            System.out.println("Category " + category + " does not exist.");
        }
    }

    public void listAllCategories() {
        if (cityGuide.isEmpty()) {
            System.out.println("No categories found.");
        } else {
            System.out.println("City Tourist Guide Categories:");
            for (Map.Entry<String, Set<String>> entry : cityGuide.entrySet()) {
                System.out.println("Category: " + entry.getKey());
                for (String spot : entry.getValue()) {
                    System.out.println(" - " + spot);
                }
            }
        }
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            
            System.out.println("\nCity Tourist Guide");
            System.out.println("1. Add a Tourist Spot");
            System.out.println("2. Remove a Tourist Spot");
            System.out.println("3. List Tourist Spots in a Category");
            System.out.println("4. List All Categories and Tourist Spots");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter category: ");
                    String categoryToAdd = scanner.nextLine();
                    System.out.print("Enter tourist spot: ");
                    String spotToAdd = scanner.nextLine();
                    addTouristSpot(categoryToAdd, spotToAdd);
                    break;

                case 2:
                    System.out.print("Enter category: ");
                    String categoryToRemove = scanner.nextLine();
                    System.out.print("Enter tourist spot to remove: ");
                    String spotToRemove = scanner.nextLine();
                    removeTouristSpot(categoryToRemove, spotToRemove);
                    break;

                case 3: 
                    System.out.print("Enter category to list spots: ");
                    String categoryToList = scanner.nextLine();
                    listSpotsInCategory(categoryToList);
                    break;

                case 4:
                    
                    listAllCategories();
                    break;

                case 5:
                    
                    System.out.println("Exiting the City Tourist Guide.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }

    public static void main(String[] args) {
        
        CityTouristGuide guide = new CityTouristGuide();

        guide.showMenu();
    }
}
