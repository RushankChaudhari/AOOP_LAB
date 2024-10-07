package MessagingApplication;

import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    private Queue<String> buffer = new LinkedList<>();
    private int capacity;
    
    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }
    
    public synchronized void produce(String message) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait();
        }
        buffer.add(message);
        notifyAll();
    }
    
    public synchronized String consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }
        String message = buffer.poll();
        notifyAll();
        return message;
    }
}

class Producer implements Runnable {
    private SharedBuffer buffer;
    
    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        int messageCount = 0;
        try {
            while (true) {
                String message = "Message " + messageCount++;
                buffer.produce(message);
                System.out.println("Produced: " + message);
                Thread.sleep(500); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private SharedBuffer buffer;
    
    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                String message = buffer.consume();
                System.out.println("Consumed: " + message);
                Thread.sleep(1000); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class MessagingApp {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(10); 
        
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));
        
        producerThread.start();
        consumerThread.start();
    }
}
