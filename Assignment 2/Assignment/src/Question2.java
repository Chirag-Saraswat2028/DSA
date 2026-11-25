import java.util.Scanner;
public class Question2 {
	

	static class DescendingStack {

	    private int[] stack;
	    private int top;
	    private int size;

	    public DescendingStack(int size) {
	        this.size = size;
	        stack = new int[size];
	        top = size;          // as required -> grows from SIZE-1 down to 0
	    }

	    public boolean isEmpty() { return top == size; }
	    public boolean isFull()  { return top == 0; }

	    public void push(int item) {
	        if (isFull()) { System.out.println("Stack Overflow! Cannot push " + item); return; }
	        stack[--top] = item;          // pre-decrement then store
	        System.out.println(item + " pushed");
	    }

	    public void pop() {
	        if (isEmpty()) { System.out.println("Stack Underflow! Stack is empty"); return; }
	        System.out.println(stack[top++] + " popped");   // read then post-increment
	    }

	    public void peek() {
	        if (isEmpty()) { System.out.println("Stack is empty"); return; }
	        System.out.println("Top element: " + stack[top]);
	    }

	    public void display() {
	        if (isEmpty()) { System.out.println("Stack is empty"); return; }
	        System.out.print("Stack (top -> bottom): ");
	        for (int i = top; i < size; i++) System.out.print(stack[i] + " ");
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter stack size: ");
	        DescendingStack s = new DescendingStack(sc.nextInt());

	        int choice;
	        do {
	            System.out.println("\n--- DESCENDING STACK ---");
	            System.out.println("1.Push  2.Pop  3.Peek  4.Display  5.Exit");
	            System.out.print("Choice: ");
	            choice = sc.nextInt();
	            switch (choice) {
	                case 1: System.out.print("Enter value: ");
	                        s.push(sc.nextInt()); break;
	                case 2: s.pop(); break;
	                case 3: s.peek(); break;
	                case 4: s.display(); break;
	                case 5: System.out.println("Bye!"); break;
	                default: System.out.println("Invalid choice");
	            }
	        } while (choice != 5);
	        sc.close();
	    }
	}

}
