import java.util.Scanner;
public class Question2 {
	
	static class BSTRecursiveDelete {

	    static class Node {
	        int data;
	        Node left, right;
	        Node(int data) { this.data = data; }
	    }

	    public static Node insert(Node root, int data) {
	        if (root == null) return new Node(data);
	        if (data < root.data)      root.left  = insert(root.left,  data);
	        else if (data > root.data) root.right = insert(root.right, data);
	        return root;
	    }

	    public static Node delete(Node root, int key) {
	        if (root == null) {                                 
	            System.out.println("Key " + key + " not found.");
	            return null;
	        }

	      
	        if (key < root.data) {
	            root.left  = delete(root.left,  key);
	        } else if (key > root.data) {
	            root.right = delete(root.right, key);
	        } else {
	          
	            if (root.left == null)  return root.right;
	            if (root.right == null) return root.left;

	            root.data = minValue(root.right);
	           
	            root.right = delete(root.right, root.data);
	        }
	        return root;
	    }

	    private static int minValue(Node node) {
	        while (node.left != null) node = node.left;
	        return node.data;
	    }

	    public static void inorder(Node root) {
	        if (root == null) return;
	        inorder(root.left);
	        System.out.print(root.data + " ");
	        inorder(root.right);
	    }

	    
	    public static void printTree(Node root, String prefix, boolean isLeft) {
	        if (root == null) return;
	        printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
	        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + root.data);
	        printTree(root.left,  prefix + (isLeft ? "    " : "│   "), true);
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        Node root = null;

	        System.out.print("How many nodes to insert? ");
	        int n = sc.nextInt();
	        for (int i = 0; i < n; i++) {
	            System.out.print("Value " + (i + 1) + ": ");
	            root = insert(root, sc.nextInt());
	        }

	        System.out.print("Inorder before: "); inorder(root); System.out.println();

	        System.out.print("How many deletions? ");
	        int d = sc.nextInt();
	        for (int i = 0; i < d; i++) {
	            System.out.print("Delete value: ");
	            int k = sc.nextInt();
	            root = delete(root, k);
	            System.out.print("Inorder after  : ");
	            inorder(root);
	            System.out.println();
	        }
	        sc.close();
	    }
	}
}
