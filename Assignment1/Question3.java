import java.util.Scanner;

public class Question3 {
	public static void linearSearch(int arr[]) {
		int n=arr.length;
		int key;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Key you want to search");
		key=sc.nextInt();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==key)
				System.out.println("Key Found at Index"+i);
			else
				System.out.println("Key Not Found");
		}
		
	}
	public static void main(String[] args) {
		int[] arr= {10,20,30,40,50};
		Question3.linearSearch(arr);
	}

}
