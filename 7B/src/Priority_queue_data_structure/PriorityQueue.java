package Priority_queue_data_structure;

import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueue<T extends Comparable<T>> {
    private ArrayList<T> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void enqueue(T element) {
        heap.add(element);                
        heapifyUp(heap.size() - 1);       
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }
        Collections.swap(heap, 0, heap.size() - 1);  
        T removedElement = heap.remove(heap.size() - 1);  
        heapifyDown(0);  
        return removedElement;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }
        return heap.get(0);  
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        if (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
            Collections.swap(heap, index, parentIndex);  
            heapifyUp(parentIndex);  
        }
    }

    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChild;
        }

        if (smallest != index) {
            Collections.swap(heap, index, smallest);
            heapifyDown(smallest);
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> intQueue = new PriorityQueue<>();
        intQueue.enqueue(30);
        intQueue.enqueue(10);
        intQueue.enqueue(20);
        System.out.println("Integer Priority Queue:");
        System.out.println("Peek: " + intQueue.peek());
        System.out.println("Dequeue: " + intQueue.dequeue());
        System.out.println("Peek after dequeue: " + intQueue.peek()); 

        PriorityQueue<Double> doubleQueue = new PriorityQueue<>();
        doubleQueue.enqueue(4.2);
        doubleQueue.enqueue(1.5);
        doubleQueue.enqueue(3.7);
        System.out.println("\nDouble Priority Queue:");
        System.out.println("Peek: " + doubleQueue.peek()); 
        System.out.println("Dequeue: " + doubleQueue.dequeue()); 
        System.out.println("Peek after dequeue: " + doubleQueue.peek()); 

        PriorityQueue<String> stringQueue = new PriorityQueue<>();
        stringQueue.enqueue("orange");
        stringQueue.enqueue("apple");
        stringQueue.enqueue("banana");
        System.out.println("\nString Priority Queue:");
        System.out.println("Peek: " + stringQueue.peek()); 
        System.out.println("Dequeue: " + stringQueue.dequeue()); 
        System.out.println("Peek after dequeue: " + stringQueue.peek());
    }
}

