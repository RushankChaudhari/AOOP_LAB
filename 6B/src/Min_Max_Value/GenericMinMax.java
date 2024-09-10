package Min_Max_Value;

interface MinMax<T extends Comparable<T>> {
 T findMin(T[] array); 
 T findMax(T[] array); 
}

class MinMaxImpl<T extends Comparable<T>> implements MinMax<T> {

 @Override
 public T findMin(T[] array) {
     if (array == null || array.length == 0) {
         return null; 
     }
     T min = array[0];
     for (T element : array) {
         if (element.compareTo(min) < 0) { 
             min = element;
         }
     }
     return min; 
 }

 @Override
 public T findMax(T[] array) {
     if (array == null || array.length == 0) {
         return null; 
     }
     T max = array[0]; 
     for (T element : array) {
         if (element.compareTo(max) > 0) { 
             max = element;
         }
     }
     return max; 
 }
}

public class GenericMinMax {
 public static void main(String[] args) {
     
     Integer[] intArray = {12, 45, 67, 23, 89, 4};
     MinMaxImpl<Integer> intMinMax = new MinMaxImpl<>();
     System.out.println("Integer Array:");
     System.out.println("Min: " + intMinMax.findMin(intArray));
     System.out.println("Max: " + intMinMax.findMax(intArray));

     
     Float[] floatArray = {23.5f, 67.8f, 1.2f, 99.9f, 45.6f};
     MinMaxImpl<Float> floatMinMax = new MinMaxImpl<>();
     System.out.println("\nFloat Array:");
     System.out.println("Min: " + floatMinMax.findMin(floatArray));
     System.out.println("Max: " + floatMinMax.findMax(floatArray));

   
     String[] stringArray = {"apple", "orange", "banana", "kiwi"};
     MinMaxImpl<String> stringMinMax = new MinMaxImpl<>();
     System.out.println("\nString Array:");
     System.out.println("Min: " + stringMinMax.findMin(stringArray));
     System.out.println("Max: " + stringMinMax.findMax(stringArray));

   
     Character[] charArray = {'a', 'z', 'r', 'b', 'x'};
     MinMaxImpl<Character> charMinMax = new MinMaxImpl<>();
     System.out.println("\nCharacter Array:");
     System.out.println("Min: " + charMinMax.findMin(charArray));
     System.out.println("Max: " + charMinMax.findMax(charArray));
 }
}

