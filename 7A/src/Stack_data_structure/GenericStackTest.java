package Stack_data_structure;


interface Stack<T> {
 void push(T element);     
 T pop();                  
 T peek();                 
 boolean isEmpty();        
 int size();               
}

class ArrayStack<T> implements Stack<T> {
 private T[] stack;
 private int top;
 private static final int DEFAULT_CAPACITY = 10;

 @SuppressWarnings("unchecked")
 public ArrayStack() {
     stack = (T[]) new Object[DEFAULT_CAPACITY]; 
     top = -1;
 }

 @Override
 public void push(T element) {
     if (top == stack.length - 1) {
         resize(2 * stack.length); 
     }
     stack[++top] = element; 
 }

 @Override
 public T pop() {
     if (isEmpty()) {
         throw new RuntimeException("Stack is empty");
     }
     T element = stack[top];
     stack[top--] = null; 
     return element;
 }

 @Override
 public T peek() {
     if (isEmpty()) {
         throw new RuntimeException("Stack is empty");
     }
     return stack[top]; 
 }

 @Override
 public boolean isEmpty() {
     return top == -1;
 }

 @Override
 public int size() {
     return top + 1;
 }

 @SuppressWarnings("unchecked")
 private void resize(int newCapacity) {
     T[] newStack = (T[]) new Object[newCapacity]; 
     System.arraycopy(stack, 0, newStack, 0, size()); 
     stack = newStack;
 }
}

class LinkedListStack<T> implements Stack<T> {
 private class Node {
     T data;
     Node next;
     Node(T data) {
         this.data = data;
     }
 }

 private Node top;
 private int size;

 public LinkedListStack() {
     top = null;
     size = 0;
 }

 @Override
 public void push(T element) {
     Node newNode = new Node(element);
     newNode.next = top;
     top = newNode; 
     size++;
 }

 @Override
 public T pop() {
     if (isEmpty()) {
         throw new RuntimeException("Stack is empty");
     }
     T data = top.data;
     top = top.next; 
     size--;
     return data;
 }

 @Override
 public T peek() {
     if (isEmpty()) {
         throw new RuntimeException("Stack is empty");
     }
     return top.data; 
 }

 @Override
 public boolean isEmpty() {
     return top == null;
 }

 @Override
 public int size() {
     return size;
 }
}

public class GenericStackTest {
 public static void main(String[] args) {
     
     Stack<Integer> arrayStack = new ArrayStack<>();
     System.out.println("Testing ArrayStack with Integer:");
     arrayStack.push(10);
     arrayStack.push(20);
     arrayStack.push(30);
     System.out.println("Top element (peek): " + arrayStack.peek()); 
     System.out.println("Pop: " + arrayStack.pop()); 
     System.out.println("Is stack empty? " + arrayStack.isEmpty()); 
     System.out.println("Stack size: " + arrayStack.size()); 
     
     Stack<String> linkedListStack = new LinkedListStack<>();
     System.out.println("\nTesting LinkedListStack with String:");
     linkedListStack.push("apple");
     linkedListStack.push("banana");
     linkedListStack.push("cherry");
     System.out.println("Top element (peek): " + linkedListStack.peek());
     System.out.println("Pop: " + linkedListStack.pop()); 
     System.out.println("Is stack empty? " + linkedListStack.isEmpty()); 
     System.out.println("Stack size: " + linkedListStack.size()); 

     Stack<Character> charStack = new LinkedListStack<>();
     System.out.println("\nTesting LinkedListStack with Character:");
     charStack.push('A');
     charStack.push('B');
     charStack.push('C');
     System.out.println("Top element (peek): " + charStack.peek()); 
     System.out.println("Pop: " + charStack.pop()); 
     System.out.println("Is stack empty? " + charStack.isEmpty()); 
     System.out.println("Stack size: " + charStack.size()); 
 }
}

