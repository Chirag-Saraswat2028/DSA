class LinkedLists{
	static class Node{
		private int data;
		private Node next;
		
		public Node(int value) {
			data= value;
			next=null;
		}
	}
	private Node head;
	
	public LinkedLists() {
		head=null;
	}
	
	public void addFirst(int value) {
		Node newNode=new Node(value);
		newNode.next=head;
		head=newNode;
	}
	
	public void addSorted(int value) {
	    Node newNode = new Node(value);
	    if (head == null || value <= head.data) {
	        newNode.next = head;
	        head = newNode;
	    }
	    else {
	        Node trav = head;
	        while (trav.next != null && trav.next.data < value) {
	            trav = trav.next;
	        }
	        newNode.next = trav.next;
	        trav.next = newNode;
	    }
	}
	public void display() {
		Node trav=head;
		while(trav!=null) {
			System.out.println(trav.data);
			trav=trav.next;
		}
		System.out.println();
	}
}
public class Question2 {

	public static void main(String[] args) {
	LinkedLists l1=new LinkedLists();
	l1.addFirst(20);
	l1.addFirst(10);
	l1.addSorted(5);
	l1.display();
	}

}
