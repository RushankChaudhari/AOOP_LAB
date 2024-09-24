package Five_functions;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NumberPrinter {

    private static final Lock lock = new ReentrantLock();
    private static int currentNumber = 1;

    public static void main(String[] args) {
        Thread thread2 = new Thread(() -> printTwo());
        Thread thread3 = new Thread(() -> printThree());
        Thread thread4 = new Thread(() -> printFour());
        Thread thread5 = new Thread(() -> printFive());
        Thread threadNumber = new Thread(() -> printNumber());

        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        threadNumber.start();

        try {
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            threadNumber.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printTwo() {
        while (currentNumber <= 15) {
            lock.lock();
            try {
                if (currentNumber % 2 == 0 && currentNumber % 3 != 0 && currentNumber % 4 != 0 && currentNumber % 5 != 0) {
                    System.out.println("Divisible by 2: " + currentNumber);
                    currentNumber++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void printThree() {
        while (currentNumber <= 15) {
            lock.lock();
            try {
                if (currentNumber % 3 == 0 && currentNumber % 4 != 0 && currentNumber % 5 != 0) {
                    System.out.println("Divisible by 3: " + currentNumber);
                    currentNumber++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void printFour() {
        while (currentNumber <= 15) {
            lock.lock();
            try {
                if (currentNumber % 4 == 0 && currentNumber % 5 != 0) {
                    System.out.println("Divisible by 4: " + currentNumber);
                    currentNumber++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void printFive() {
        while (currentNumber <= 15) {
            lock.lock();
            try {
                if (currentNumber % 5 == 0) {
                    System.out.println("Divisible by 5: " + currentNumber);
                    currentNumber++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void printNumber() {
        while (currentNumber <= 15) {
            lock.lock();
            try {
                if (currentNumber % 2 != 0 && currentNumber % 3 != 0 && currentNumber % 4 != 0 && currentNumber % 5 != 0) {
                    System.out.println("Number: " + currentNumber);
                    currentNumber++;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
