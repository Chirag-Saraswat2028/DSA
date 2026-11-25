
public class Question2 {
	static class BSTLevelOfNode {

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

	    public static int findLevel(Node root, int key) {
	        int level = 0;
	        Node curr = root;
	        while (curr != null) {
	            if (key == curr.data) return level;
	            curr = (key < curr.data) ? curr.left : curr.right;
	            level++;
	        }
	        return -1;                        
	    }

	    public static void main(String[] args) {
	        int[] values = {50, 30, 70, 20, 40, 60, 80, 35, 45};
	        Node root = null;
	        for (int v : values) root = insert(root, v);

	        int[] keys = {50, 20, 40, 35, 80, 99};
	        for (int k : keys) {
	            int lvl = findLevel(root, k);
	            System.out.println("Node " + k + " -> level = "
	                    + (lvl == -1 ? "NOT FOUND" : lvl));
	        }
	    }
	}
}
