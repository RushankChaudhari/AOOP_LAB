package CO1_Project_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactorization {

    public static List<Integer> factorize(int number) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= number; i++) {
            while (number % i == 0) {
                factors.add(i);
                number /= i;
            }
        }

        return factors;
    }



public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter a number to get its prime factors: ");
    int number = scanner.nextInt();

    List<Integer> factors = factorize(number);

    System.out.println("Prime factors of " + number + " are: " + factors);
    
    scanner.close(); 
}
}