class LinkedList{
	static class Node{
		private int data;
		private Node next;
		
		public Node(int value) {
			data= value;
			next=null;
		}
	}
	private Node head;
	
	public LinkedList() {
		head=null;
	}
	
	public void addLast(int value) {
		Node newNode=new Node(value);
		Node trav=head;
		if(head==null)
			head=newNode;
		while(trav.next!=null) {
			trav=trav.next;
		}
		trav.next=newNode;
	}
	
	public void addFirst(int value) {
		Node newNode=new Node(value);
		newNode.next=head;
		head=newNode;
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

public class Question1 {
	public static void main(String[] args) {
		LinkedList li=new LinkedList();
		li.addFirst(20);
		li.addFirst(10);
		li.addLast(30);
		li.display();

	}

}
