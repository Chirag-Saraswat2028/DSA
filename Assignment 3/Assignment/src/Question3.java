import java.util.Scanner;

public class Question3 {
	
	static class CircularLinkedList {

	    static class Node {
	        int data;
	        Node next;
	        Node(int data) { this.data = data; this.next = null; }
	    }

	    private Node head = null;
	    private int size = 0;

	    public boolean addAtPosition(int pos, int data) {
	        if (pos < 1 || pos > size + 1) {
	            System.out.println("Invalid position " + pos + " (valid: 1.." + (size + 1) + ")");
	            return false;
	        }
	        Node newNode = new Node(data);

	       
	        if (head == null) {
	            head = newNode;
	            newNode.next = head;      
	            size++;
	            return true;
	        }

	        if (pos == 1) {
	            Node tail = head;
	            while (tail.next != head) tail = tail.next;  
	            newNode.next = head;
	            tail.next = newNode;
	            head = newNode;
	            size++;
	            return true;
	        }

	  
	        Node curr = head;
	        for (int i = 1; i < pos - 1; i++) curr = curr.next;
	        newNode.next = curr.next;
	        curr.next = newNode;
	        size++;
	        return true;
	    }

	  
	    public boolean deleteAtPosition(int pos) {
	        if (head == null) { System.out.println("List is empty"); return false; }
	        if (pos < 1 || pos > size) {
	            System.out.println("Invalid position " + pos + " (valid: 1.." + size + ")");
	            return false;
	        }

	        if (size == 1) {
	            System.out.println("Deleted " + head.data);
	            head = null;
	            size--;
	            return true;
	        }

	   
	        if (pos == 1) {
	            Node tail = head;
	            while (tail.next != head) tail = tail.next;   
	            System.out.println("Deleted " + head.data);
	            tail.next = head.next;
	            head = head.next;
	            size--;
	            return true;
	        }


	        Node curr = head;
	        for (int i = 1; i < pos - 1; i++) curr = curr.next;
	        Node toDelete = curr.next;
	        System.out.println("Deleted " + toDelete.data);
	        curr.next = toDelete.next;    
	        size--;
	        return true;
	    }

	    public void display() {
	        if (head == null) { System.out.println("List is empty"); return; }
	        System.out.print("Circular list: ");
	        Node curr = head;
	        do {
	            System.out.print(curr.data + " -> ");
	            curr = curr.next;
	        } while (curr != head);
	        System.out.println("(back to " + head.data + ")   size = " + size);
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        CircularLinkedList cll = new CircularLinkedList();

	        int choice;
	        do {
	            System.out.println("\n--- CIRCULAR LINKED LIST ---");
	            System.out.println("1.Add at position  2.Delete at position  3.Display  4.Exit");
	            System.out.print("Choice: ");
	            choice = sc.nextInt();
	            switch (choice) {
	                case 1:
	                    System.out.print("Position (1-based): ");
	                    int p1 = sc.nextInt();
	                    System.out.print("Value: ");
	                    int v1 = sc.nextInt();
	                    if (cll.addAtPosition(p1, v1)) cll.display();
	                    break;
	                case 2:
	                    System.out.print("Position to delete: ");
	                    int p2 = sc.nextInt();
	                    if (cll.deleteAtPosition(p2)) cll.display();
	                    break;
	                case 3: cll.display(); break;
	                case 4: System.out.println("Bye!"); break;
	                default: System.out.println("Invalid choice");
	            }
	        } while (choice != 4);
	        sc.close();
	    }
	}
}