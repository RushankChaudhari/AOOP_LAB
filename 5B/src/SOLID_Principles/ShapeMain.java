package SOLID_Principles;

public class ShapeMain {
		 public static void main(String[] args) {
		     Shape rectangle = new Rectangle(5, 10);
		     Shape circle = new Circle(7);

		     System.out.println("Rectangle area: " + rectangle.calculateArea());
		     System.out.println("Circle area: " + circle.calculateArea());
		 }
		}

