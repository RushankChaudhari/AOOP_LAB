package SOLID_Principles;

class Bird {
 public void fly() {
     System.out.println("Flying...");
 }
}

class Ostrich extends Bird {
 @Override
 public void fly() {
     throw new UnsupportedOperationException("Ostriches can't fly!");
 }
}



