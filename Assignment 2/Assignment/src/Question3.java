import java.util.Scanner;
public class Question3 {
	

	static class CircularQueueWithCounter {

	    private int[] queue;
	    private int front, rear, count, size;

	    public CircularQueueWithCounter(int size) {
	        this.size = size;
	        queue = new int[size];
	        front = 0;
	        rear  = 0;
	        count = 0;
	    }

	    public boolean isEmpty() { return count == 0; }
	    public boolean isFull()  { return count == size; }

	    public void enqueue(int item) {
	        if (isFull()) { System.out.println("Queue Overflow! Cannot insert " + item); return; }
	        queue[rear] = item;
	        rear = (rear + 1) % size;
	        count++;
	        System.out.println(item + " enqueued");
	    }

	    public void dequeue() {
	        if (isEmpty()) { System.out.println("Queue Underflow! Queue is empty"); return; }
	        int item = queue[front];
	        front = (front + 1) % size;
	        count--;
	        System.out.println(item + " dequeued");
	    }

	    public void peek() {
	        if (isEmpty()) { System.out.println("Queue is empty"); return; }
	        System.out.println("Front element: " + queue[front]);
	    }

	    public void display() {
	        if (isEmpty()) { System.out.println("Queue is empty"); return; }
	        System.out.print("Circular Queue: ");
	        for (int i = 0; i < count; i++)
	            System.out.print(queue[(front + i) % size] + " ");
	        System.out.println("   (count = " + count + ")");
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter queue size: ");
	        CircularQueueWithCounter q = new CircularQueueWithCounter(sc.nextInt());

	        int choice;
	        do {
	            System.out.println("\n--- CIRCULAR QUEUE (COUNTER) ---");
	            System.out.println("1.Enqueue  2.Dequeue  3.Peek  4.Display  5.Exit");
	            System.out.print("Choice: ");
	            choice = sc.nextInt();
	            switch (choice) {
	                case 1: System.out.print("Enter value: ");
	                        q.enqueue(sc.nextInt()); break;
	                case 2: q.dequeue(); break;
	                case 3: q.peek(); break;
	                case 4: q.display(); break;
	                case 5: System.out.println("Bye!"); break;
	                default: System.out.println("Invalid choice");
	            }
	        } while (choice != 5);
	        sc.close();
	    }
	}
}
