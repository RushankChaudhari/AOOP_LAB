package lambda_expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class SortStringsDescending {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("Orange");
        stringList.add("Banana");
        stringList.add("Pineapple");

        stringList.sort((s1, s2) -> s2.compareTo(s1)); 
       
        System.out.println("Strings in descending order:");
        stringList.forEach(System.out::println);
    }
}
