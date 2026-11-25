	import java.util.Scanner;

public class Question4 {

	static class BSTRecursive {

	    static class Node {
	        int data;
	        Node left, right;
	        Node(int data) { this.data = data; }
	    }

	    public static Node add(Node root, int data) {
	        if (root == null) return new Node(data);       
	        if (data < root.data)      root.left  = add(root.left,  data);
	        else if (data > root.data) root.right = add(root.right, data);
	    
	        return root;
	    }

	    public static boolean search(Node root, int key) {
	        if (root == null)      return false;             
	        if (root.data == key)  return true;               
	        return (key < root.data)
	                ? search(root.left,  key)
	                : search(root.right, key);
	    }

	    public static void inorder(Node root) {
	        if (root == null) return;
	        inorder(root.left);
	        System.out.print(root.data + " ");
	        inorder(root.right);
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        Node root = null;

	        System.out.print("How many nodes to add? ");
	        int n = sc.nextInt();
	        for (int i = 0; i < n; i++) {
	            System.out.print("Value " + (i + 1) + ": ");
	            root = add(root, sc.nextInt());
	        }

	        System.out.print("Inorder (sorted): ");
	        inorder(root);
	        System.out.println();

	        System.out.print("How many searches? ");
	        int q = sc.nextInt();
	        for (int i = 0; i < q; i++) {
	            System.out.print("Search for: ");
	            int key = sc.nextInt();
	            System.out.println("  " + key + " : " + (search(root, key) ? "FOUND" : "NOT FOUND"));
	        }
	        sc.close();
	    }
	}
}
