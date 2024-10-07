package BoundedBuffer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class BoundedBuffer {
    private final BlockingQueue<Integer> buffer;

    public BoundedBuffer(int capacity) {
        this.buffer = new LinkedBlockingQueue<>(capacity);
    }

    public void produce(int item) throws InterruptedException {
        buffer.put(item);  
        System.out.println("Produced: " + item);
    }

    public int consume() throws InterruptedException {
        int item = buffer.take();  
        System.out.println("Consumed: " + item);
        return item;
    }
}

class Producer implements Runnable {
    private final BoundedBuffer buffer;
    private boolean running = true;

    public Producer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int item = 0;
        while (running) {
            try {
                buffer.produce(item);  
                item++;
                TimeUnit.MILLISECONDS.sleep(500);  
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted");
            }
        }
    }

    public void stop() {
        running = false;
    }
}

class Consumer implements Runnable {
    private final BoundedBuffer buffer;
    private boolean running = true;

    public Consumer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (running) {
            try {
                buffer.consume();  
                TimeUnit.MILLISECONDS.sleep(800);  
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted");
            }
        }
    }

    public void stop() {
        running = false;
    }
}

public class BoundedBufferApplication {
    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer(10);  
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        producer.stop();
        consumer.stop();
        producerThread.interrupt();
        consumerThread.interrupt();
    }
}

