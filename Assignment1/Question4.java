import java.util.Scanner;

public class Question4 {
	
	public static void BinarySearch(int arr[]) {
		int key;
		Scanner sc=new Scanner(System.in);
		key=sc.nextInt();
		int mid;
		int left=0;
		int right=arr.length-1;
		while (left<right) {
			mid=(left+right)/2;
			if(key==arr[mid])
				System.out.println("Key Found");
			else if(key>arr[mid])
				right=mid-1;
			else
				left=mid+1;
		}
	}
	public static void main(String[] args) {
		int[]arr= {90,80,70,60,50,40,30};
		Question4.BinarySearch(arr);
	}

}
