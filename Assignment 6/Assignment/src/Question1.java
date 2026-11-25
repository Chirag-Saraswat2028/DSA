import java.util.Arrays;
import java.util.Scanner;
public class Question1 {
	static class InsertionSortDescending {

	    public static void insertionSortDescending(int[] arr) {
	        int n = arr.length;
	        for (int i = 1; i < n; i++) {
	            int key = arr[i];
	            int j = i - 1;

	            
	            while (j >= 0 && arr[j] < key) {     
	                arr[j + 1] = arr[j];
	                j--;
	            }
	            arr[j + 1] = key;
	        }
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("How many elements? ");
	        int n = sc.nextInt();
	        int[] arr = new int[n];
	        System.out.println("Enter " + n + " elements:");
	        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

	        System.out.println("Before: " + Arrays.toString(arr));
	        insertionSortDescending(arr);
	        System.out.println("After (descending): " + Arrays.toString(arr));
	        sc.close();
	    }
	}
}
