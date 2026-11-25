	import java.util.Scanner;
public class Question1 {

	static class SinglyLinkedList {

	    static class Node {
	        int data;
	        Node next;
	        Node(int data) { this.data = data; this.next = null; }
	    }

	    private Node head = null;

	    public void insertEnd(int data) {
	        Node newNode = new Node(data);
	        if (head == null) { head = newNode; return; }
	        Node curr = head;
	        while (curr.next != null) curr = curr.next;
	        curr.next = newNode;
	    }

	    public boolean insertAfter(int key, int data) {
	        Node curr = head;
	        while (curr != null && curr.data != key) curr = curr.next;

	        if (curr == null) {
	            System.out.println("Key " + key + " not found — cannot insert after.");
	            return false;
	        }
	        Node newNode = new Node(data);
	        newNode.next = curr.next;  
	        curr.next = newNode;        
	        return true;
	    }

	    public boolean insertBefore(int key, int data) {
	        if (head == null) {
	            System.out.println("List is empty — key not found.");
	            return false;
	        }
	      
	        if (head.data == key) {
	            Node newNode = new Node(data);
	            newNode.next = head;
	            head = newNode;
	            return true;
	        }
	 
	        Node curr = head;
	        while (curr.next != null && curr.next.data != key) curr = curr.next;

	        if (curr.next == null) {
	            System.out.println("Key " + key + " not found — cannot insert before.");
	            return false;
	        }
	        Node newNode = new Node(data);
	        newNode.next = curr.next;  
	        curr.next = newNode;       
	        return true;
	    }

	
	    public void display() {
	        if (head == null) { System.out.println("List is empty"); return; }
	        Node curr = head;
	        System.out.print("List: ");
	        while (curr != null) {
	            System.out.print(curr.data + (curr.next != null ? " -> " : ""));
	            curr = curr.next;
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        SinglyLinkedList list = new SinglyLinkedList();

	        System.out.print("How many initial nodes? ");
	        int n = sc.nextInt();
	        for (int i = 0; i < n; i++) {
	            System.out.print("Enter value " + (i + 1) + ": ");
	            list.insertEnd(sc.nextInt());
	        }
	        list.display();

	        int choice;
	        do {
	            System.out.println("\n--- SINGLY LINKED LIST ---");
	            System.out.println("1.Insert After  2.Insert Before  3.Display  4.Exit");
	            System.out.print("Choice: ");
	            choice = sc.nextInt();
	            switch (choice) {
	                case 1:
	                    System.out.print("Insert after which value? ");
	                    int k1 = sc.nextInt();
	                    System.out.print("New value: ");
	                    int v1 = sc.nextInt();
	                    if (list.insertAfter(k1, v1)) list.display();
	                    break;
	                case 2:
	                    System.out.print("Insert before which value? ");
	                    int k2 = sc.nextInt();
	                    System.out.print("New value: ");
	                    int v2 = sc.nextInt();
	                    if (list.insertBefore(k2, v2)) list.display();
	                    break;
	                case 3: list.display(); break;
	                case 4: System.out.println("Bye!"); break;
	                default: System.out.println("Invalid choice");
	            }
	        } while (choice != 4);
	        sc.close();
	    }
	}
}
