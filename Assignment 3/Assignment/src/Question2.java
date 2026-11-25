import java.util.Scanner;
public class Question2 {
	static class SortedLinkedList {

	    static class Node {
	        int data;
	        Node next;
	        Node(int data) { this.data = data; this.next = null; }
	    }

	    private Node head = null;

	    public void insertSorted(int value) {
	        Node newNode = new Node(value);

	        if (head == null || value < head.data) {
	            newNode.next = head;
	            head = newNode;
	            return;
	        }

	        Node curr = head;
	        while (curr.next != null && curr.next.data < value) {
	            curr = curr.next;
	        }
	        newNode.next = curr.next;
	        curr.next = newNode;
	    }

	    public void display() {
	        if (head == null) { System.out.println("List is empty"); return; }
	        Node curr = head;
	        System.out.print("Sorted list: ");
	        while (curr != null) {
	            System.out.print(curr.data + (curr.next != null ? " -> " : ""));
	            curr = curr.next;
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        SortedLinkedList list = new SortedLinkedList();

	        System.out.print("How many values to insert? ");
	        int n = sc.nextInt();
	        for (int i = 0; i < n; i++) {
	            System.out.print("Value " + (i + 1) + ": ");
	            list.insertSorted(sc.nextInt());
	            list.display();
	        }
	        sc.close();
	    }
	}
}
