import java.util.Scanner;

public class Question2 {
	public static void linearSearch(int arr[]) {
		int n=arr.length;
		int key;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Key you want to search");
		key=sc.nextInt();
		int res = 0;
		for(int i=0;i<n;i++) {
		if(arr[i]==key)
			res=i;
		}
		if(res!=0)
		System.out.println("Last Occurance of key is "+ res);
		else
			System.out.println("Key Not Found");
	}
	public static void main(String[] args) {
		int[] arr= {10,20,30,10,40,10,50};
		Question2.linearSearch(arr);
	}

}
