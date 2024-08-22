package SOLID_Principles;

public class BirdMain {
	 public static void main(String[] args) {
	     Bird bird = new Bird();
	     bird.fly();

	     Bird ostrich = new Ostrich();
	     try {
	         ostrich.fly();
	     } catch (UnsupportedOperationException e) {
	         System.out.println(e.getMessage());
	     }
	 }

}
