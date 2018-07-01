

import java.util.Scanner;

public class Q2748 {
	static long[] arr;

	static long fibonacci(int n) {
		if (arr[n] != 0) {
			
		} else if (n == 0 || n == 1) {
			arr[n] = n;
		} else {
			arr[n] = fibonacci(n - 1) + fibonacci(n - 2);
		}
		return arr[n];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		arr = new long[N + 1];
		fibonacci(N);
		System.out.println(arr[N]);
	}
}
