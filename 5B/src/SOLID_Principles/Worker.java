package SOLID_Principles;

interface Worker {
 void work();
}

interface Eater {
 void eat();
}

class Robot implements Worker {
 @Override
 public void work() {
     System.out.println("Robot working...");
 }
}

class Human implements Worker, Eater {
 @Override
 public void work() {
     System.out.println("Human working...");
 }

 @Override
 public void eat() {
     System.out.println("Human eating...");
 }
}


