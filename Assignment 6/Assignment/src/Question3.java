	import java.util.ArrayDeque;
	import java.util.Deque;

public class Question3{

	static class IterativeTraversals {

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

	    public static void preorder(Node root) {
	        if (root == null) return;
	        Deque<Node> stack = new ArrayDeque<>();
	        stack.push(root);
	        System.out.print("Preorder : ");
	        while (!stack.isEmpty()) {
	            Node curr = stack.pop();
	            System.out.print(curr.data + " ");
	          
	            if (curr.right != null) stack.push(curr.right);
	            if (curr.left  != null) stack.push(curr.left);
	        }
	        System.out.println();
	    }

	    public static void inorder(Node root) {
	        Deque<Node> stack = new ArrayDeque<>();
	        Node curr = root;
	        System.out.print("Inorder  : ");
	        while (curr != null || !stack.isEmpty()) {
	         
	            while (curr != null) {
	                stack.push(curr);
	                curr = curr.left;
	            }
	            curr = stack.pop();         
	            System.out.print(curr.data + " ");
	            curr = curr.right;          
	        }
	        System.out.println();
	    }

	    public static void postorder(Node root) {
	        if (root == null) return;
	        Deque<Node> stack1 = new ArrayDeque<>();
	        Deque<Node> stack2 = new ArrayDeque<>();

	        stack1.push(root);
	        while (!stack1.isEmpty()) {
	            Node curr = stack1.pop();
	            stack2.push(curr);                      
	            if (curr.left  != null) stack1.push(curr.left);
	            if (curr.right != null) stack1.push(curr.right);
	        }
	        System.out.print("Postorder: ");
	        while (!stack2.isEmpty()) System.out.print(stack2.pop().data + " ");
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        int[] values = {50, 30, 70, 20, 40, 60, 80};
	        Node root = null;
	        for (int v : values) root = insert(root, v);

	        preorder(root);
	        inorder(root);
	        postorder(root);
	    }
	}
}
