
public class Question1 {
	static class BSTSuccessor {

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

	    public static Node search(Node root, int key) {
	        if (root == null || root.data == key) return root;
	        return (key < root.data) ? search(root.left, key)
	                                 : search(root.right, key);
	    }

	   
	    private static Node leftmost(Node node) {
	        while (node != null && node.left != null) node = node.left;
	        return node;
	    }

	  
	    public static Node inorderSuccessor(Node root, int key) {

	        Node target = search(root, key);
	        if (target == null) {
	            System.out.println("Node " + key + " not found in BST.");
	            return null;
	        }

	        if (target.right != null) {
	            return leftmost(target.right);
	        }

	        Node successor = null;
	        Node curr = root;
	        while (curr != null) {
	            if (key < curr.data) {
	                successor = curr;        
	                curr = curr.left;
	            } else if (key > curr.data) {
	                curr = curr.right;
	            } else {
	                break;                  
	            }
	        }
	        return successor;              
	    }

	    public static void main(String[] args) {
	        int[] values = {50, 30, 70, 20, 40, 60, 80, 35, 45, 65, 75};
	        Node root = null;
	        for (int v : values) root = insert(root, v);

	        int[] keys = {50, 30, 20, 45, 80, 35, 75, 100};
	        for (int k : keys) {
	            Node succ = inorderSuccessor(root, k);
	            System.out.println("Successor of " + k + " = "
	                    + (succ == null ? "NONE (max or absent)" : succ.data));
	        }
	    }
	}
}
