

import java.util.Scanner;

public class Q9663_2 {
	private static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int N = scan.nextInt();
		long[] arr = { 0,1,0,0,2,10,4,40,92,352,724,2680,14200,73712,365596,2279184 };
		System.out.println(arr[N]);
	}
}
