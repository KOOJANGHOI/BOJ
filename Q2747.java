

import java.util.Scanner;

public class Q2747 {
	static int[] arr;
	private static Scanner scan;
	static int fibo(int n) {
		if(arr[n] != 0)
			return arr[n];
		if(n == 0 || n == 1) {
			arr[n] = 1;
		} else {
			arr[n] = fibo(n-1) + fibo(n-2);
		}
		return arr[n];
	}
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int N = scan.nextInt();
		arr = new int[N+1];
		System.out.println(fibo(N-1));
	}
}
