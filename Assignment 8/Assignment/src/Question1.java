import java.util.Arrays;
import java.util.Scanner;

public class Question1 {

	static class MinHeap {

	    private int[] heap;
	    private int size;       
	    private int capacity;

	    public MinHeap(int capacity) {
	        this.capacity = capacity;
	        this.heap = new int[capacity];
	        this.size = 0;
	    }

	    private int parent(int i) { return (i - 1) / 2; }
	    private int left(int i)   { return 2 * i + 1; }
	    private int right(int i)  { return 2 * i + 2; }
	    private void swap(int i, int j) {
	        int t = heap[i]; heap[i] = heap[j]; heap[j] = t;
	    }

	    public boolean isEmpty() { return size == 0; }
	    public boolean isFull()  { return size == capacity; }
	    public int peek() {
	        if (isEmpty()) throw new RuntimeException("Heap is empty");
	        return heap[0];
	    }

	                     
	    public void add(int value) {
	        if (isFull()) {
	            System.out.println("Heap Overflow! Cannot add " + value);
	            return;
	        }
	        heap[size] = value;
	        int i = size;
	        size++;

	  
	        while (i > 0 && heap[i] < heap[parent(i)]) {
	            swap(i, parent(i));
	            i = parent(i);
	        }
	        System.out.println(value + " added");
	    }

	    public int deleteMin() {
	        if (isEmpty()) {
	            System.out.println("Heap Underflow! Heap is empty");
	            return -1;
	        }
	        int min = heap[0];
	        heap[0] = heap[size - 1];
	        size--;

	     
	        int i = 0;
	        while (true) {
	            int l = left(i), r = right(i);
	            int smallest = i;

	            if (l < size && heap[l] < heap[smallest]) smallest = l;
	            if (r < size && heap[r] < heap[smallest]) smallest = r;

	            if (smallest == i) break;        

	            swap(i, smallest);
	            i = smallest;
	        }
	        System.out.println(min + " deleted (min)");
	        return min;
	    }


	    public void display() {
	        if (isEmpty()) { System.out.println("Heap is empty"); return; }
	        System.out.print("Heap array : ");
	        for (int i = 0; i < size; i++) System.out.print(heap[i] + " ");
	        System.out.println("   (size = " + size + ", min = " + heap[0] + ")");
	    }

	
	    public void displayTree() {
	        if (isEmpty()) { System.out.println("Heap is empty"); return; }
	        System.out.println("Tree view:");
	        printTree(0, "", true);
	    }
	    private void printTree(int i, String prefix, boolean isLeft) {
	        if (i >= size) return;
	        printTree(right(i), prefix + (isLeft ? "│   " : "    "), false);
	        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + heap[i]);
	        printTree(left(i),  prefix + (isLeft ? "    " : "│   "), true);
	    }

	  
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter heap capacity: ");
	        MinHeap h = new MinHeap(sc.nextInt());

	        int choice;
	        do {
	            System.out.println("\n--- MIN HEAP ---");
	            System.out.println("1.Add  2.Delete-min  3.Peek  4.Display  5.Display tree  6.Exit");
	            System.out.print("Choice: ");
	            choice = sc.nextInt();
	            switch (choice) {
	                case 1: System.out.print("Value to add: ");
	                        h.add(sc.nextInt()); break;
	                case 2: h.deleteMin(); break;
	                case 3:
	                    if (h.isEmpty()) System.out.println("Heap is empty");
	                    else System.out.println("Min = " + h.peek());
	                    break;
	                case 4: h.display(); break;
	                case 5: h.displayTree(); break;
	                case 6: System.out.println("Bye!"); break;
	                default: System.out.println("Invalid choice");
	            }
	        } while (choice != 6);
	        sc.close();
	    }
	}
}
